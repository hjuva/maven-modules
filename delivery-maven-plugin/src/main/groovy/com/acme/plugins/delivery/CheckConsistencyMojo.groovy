package com.acme.plugins.delivery

import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.model.Dependency
import org.apache.maven.plugin.MojoExecutionException
import org.apache.maven.project.MavenProject
import org.apache.maven.project.MavenProjectBuilder
import org.codehaus.gmaven.mojo.GroovyMojo


/**
 * Checks version consistency between the dependencies of a project.
 *
 * For instance, if the current project has a dependency on A:1 (project A in
 * version 1) and B:2, and B has a dependency on A, the goal is to check that
 * the dependency in B:2's pom is on A:1, and not another version.
 *
 * @goal check-version-consistency
 */
class CheckConsistencyMojo extends GroovyMojo {
	/**
	 * @parameter expression="${project}"
	 * @required
	 * @readonly
	 */
	MavenProject project

	/** @component */
	MavenProjectBuilder mavenProjectBuilder;

    /** @component */
    private ArtifactFactory artifactFactory;

    /** @parameter expression="${localRepository}" */
    private ArtifactRepository localRepository;

    /** @parameter expression="${project.remoteArtifactRepositories}" */
    private List remoteRepositories;

	/**
	 * Executes the mojo.
	 */
	void execute() {
	
	
	
	
		// First pass to build a map with the dependencies' versions
		// (non-transitive)
		def deliveryVersions = [:]
		for (dependency in project.dependencies) {
			deliveryVersions[dependency.managementKey] = dependency.version
		}

		// Second pass to check the consistency of the dependencies'
		// dependencies
		def wasError = false
		for (dependency in project.dependencies) {
		
			// Make a project to get access to second-level dependencies
			def artifact = artifactFactory.createArtifact(
				dependency.groupId, dependency.artifactId, dependency.version,
				dependency.scope, "pom")
			def slProject = mavenProjectBuilder.buildFromRepository(artifact,
				remoteRepositories, localRepository, false)
		
			// Traverse second-level dependencies and compare the version of
			// known artifacts	
			for (slDependency in slProject.dependencies) {
				def refVersion = deliveryVersions[slDependency.managementKey]
				if (refVersion != null && refVersion != slDependency.version) {
					log.error("Inconsistency in versions: " + dependency.managementKey +
						" uses " + slDependency.managementKey + " in version " +
						slDependency.version + ", but in " + project.name +
						" the reference version is defined as " + refVersion)
					wasError = true
				}
			}
			// Don't forget to check the parent, which is also a dependency
			if (slProject.parent != null) {
				def parentDep = new Dependency(groupId : slProject.parent.groupId,
					artifactId : slProject.parent.artifactId,
					version : slProject.parent.version,
					scope : "compile",
					type : slProject.parent.packaging)

				def refVersion = deliveryVersions[parentDep.managementKey]
				if (refVersion != null && refVersion != parentDep.version) {
					log.error("Inconsistency in versions: " + dependency.managementKey +
						" inherits from " + parentDep.managementKey + " in version " +
						parentDep.version + ", but in " + project.name +
						" the reference version is defined as " + refVersion)
					wasError = true
				}
			}
		}
		if (wasError) {
			throw new MojoExecutionException("Inconsistencies found, see the messages above")
		}
		System.setProperty("maven.delivery.mainVersion", project.version);
	}
}
