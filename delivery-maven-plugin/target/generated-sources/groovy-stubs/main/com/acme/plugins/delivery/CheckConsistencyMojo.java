//
// Generated stub from file:/Users/henningjuva/code/maven-modules-example/delivery-maven-plugin/src/main/groovy/com/acme/plugins/delivery/CheckConsistencyMojo.groovy
//

package com.acme.plugins.delivery;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectBuilder;
import org.codehaus.gmaven.mojo.GroovyMojo;

/**
 * Checks version consistency between the dependencies of a project.
 * 
 * For instance, if the current project has a dependency on A:1 (project A in
 * version 1) and B:2, and B has a dependency on A, the goal is to check that
 * the dependency in B:2's pom is on A:1, and not another version.
 *
 * @goal check-version-consistency
 */
public class CheckConsistencyMojo
    extends GroovyMojo
    implements groovy.lang.GroovyObject
{
    /**
     * @parameter expression="${project}"
     * @required
     * @readonly
     */
    private MavenProject project = null;
    public MavenProject getProject() {
        throw new InternalError("Stubbed method");
    }
    public void setProject(MavenProject value) {
        throw new InternalError("Stubbed method");
    }

    /**
     * @component
     */
    private MavenProjectBuilder mavenProjectBuilder = null;
    public MavenProjectBuilder getMavenProjectBuilder() {
        throw new InternalError("Stubbed method");
    }
    public void setMavenProjectBuilder(MavenProjectBuilder value) {
        throw new InternalError("Stubbed method");
    }

    /**
     * @component
     */
    private ArtifactFactory artifactFactory = null;

    /**
     * @parameter expression="${localRepository}"
     */
    private ArtifactRepository localRepository = null;

    /**
     * @parameter expression="${project.remoteArtifactRepositories}"
     */
    private List remoteRepositories = null;

    /**
     * Executes the mojo.
     */
    public void execute() {
        throw new InternalError("Stubbed method");
    }

    public groovy.lang.MetaClass getMetaClass() {
        throw new InternalError("Stubbed method");
    }

    public void setMetaClass(groovy.lang.MetaClass metaClass) {
        throw new InternalError("Stubbed method");
    }

    public java.lang.Object invokeMethod(java.lang.String name, java.lang.Object args) {
        throw new InternalError("Stubbed method");
    }

    public java.lang.Object getProperty(java.lang.String name) {
        throw new InternalError("Stubbed method");
    }

    public void setProperty(java.lang.String name, java.lang.Object value) {
        throw new InternalError("Stubbed method");
    }
}
