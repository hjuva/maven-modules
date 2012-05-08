package com.acme.plugins.delivery

import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.MojoExecutionException
import org.apache.maven.project.MavenProject
import org.codehaus.gmaven.mojo.GroovyMojo


/**
 * Checks if a module should be deployed.
 *
 * @goal check-deploy-needed
 */
class CheckDeployNeededMojo extends GroovyMojo {
	/**
	 * @parameter expression="${project}"
	 * @required
	 * @readonly
	 */
	MavenProject project

	/**
	 * If this parameter is specified, only the modules with the same version
	 * will be deployed.
	 * @parameter expression="${maven.delivery.version}"
	 */
    private String deliveryVersion;

	/**
	 * If this parameter is specified, only the modules with a snapshot version
	 * will be deployed.
	 * @parameter expression="${maven.delivery.deploySnapshotsOnly}"
	 */
	private boolean deploySnapshotsOnly;

	/**
	 * Used to check if the deploy plugin's global skip option is active.
	 * @parameter expression="${maven.deploy.skip}"
	 */
	private boolean skipDeploy;

	/**
	 * Executes the mojo.
	 */
	void execute() {
		// Do nothing if the user has explicitly skipped deployment
		if (!skipDeploy) {
			// It doesn't make much sense to specify both properties
			if (deliveryVersion != null && deploySnapshotsOnly) {
				throw new MojoExecutionException("Cannot specify both deployVersion and deploySnapshotsOnly");
			}

			if (deliveryVersion != null) {
				if (project.version != deliveryVersion) {
					log.warn("Skipping deploy of " + project.name + " because it is not in version " + deliveryVersion);
					project.getProperties().setProperty("maven.deploy.skip", "true");
				}
			}

			if (deploySnapshotsOnly) {
				if (! project.version.endsWith(Artifact.SNAPSHOT_VERSION)) {
					log.warn("Skipping deploy of " + project.name + " because it is not in a SNAPSHOT version");
					project.getProperties().setProperty("maven.deploy.skip", "true");
				}
			}
		}
	}
}
