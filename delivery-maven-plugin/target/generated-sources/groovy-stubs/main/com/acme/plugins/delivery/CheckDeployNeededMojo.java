//
// Generated stub from file:/Users/henningjuva/code/maven-modules-example/delivery-maven-plugin/src/main/groovy/com/acme/plugins/delivery/CheckDeployNeeded.groovy
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
import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.codehaus.gmaven.mojo.GroovyMojo;

/**
 * Checks if a module should be deployed.
 *
 * @goal check-deploy-needed
 */
public class CheckDeployNeededMojo
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
     * If this parameter is specified, only the modules with the same version
     * will be deployed.
     *
     * @parameter expression="${maven.delivery.version}"
     */
    private java.lang.String deliveryVersion = null;

    /**
     * If this parameter is specified, only the modules with a snapshot version
     * will be deployed.
     *
     * @parameter expression="${maven.delivery.deploySnapshotsOnly}"
     */
    private boolean deploySnapshotsOnly = false;

    /**
     * Used to check if the deploy plugin's global skip option is active.
     *
     * @parameter expression="${maven.deploy.skip}"
     */
    private boolean skipDeploy = false;

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
