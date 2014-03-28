package com.cedarsoft.maven.clashinspector.mojos;

import com.cedarsoft.maven.clashinspector.DependencyService;
import com.cedarsoft.maven.clashinspector.model.ClashCollectResultWrapper;
import com.cedarsoft.maven.clashinspector.visualize.HtmlVisualizer;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.artifact.DefaultArtifact;

/**
 * Created with IntelliJ IDEA.
 * User: Martin
 * Date: 14.03.14
 * Time: 16:53
 * To change this template use File | Settings | File Templates.
 */

@Mojo(name = "html", requiresProject = true, defaultPhase = LifecyclePhase.NONE)
public class ClashHtmlMojo extends AbstractClashMojo{

  @Override
  public void execute() throws MojoExecutionException, MojoFailureException {

    super.execute();
    super.printStartParameter( "html" );

    Artifact artifact;
    try {

      artifact = new DefaultArtifact( this.getProject().getArtifact().toString() );


      DependencyService dependencyService = new DependencyService();

      HtmlVisualizer htmlVisualizer = new HtmlVisualizer();

      ClashCollectResultWrapper clashCollectResultWrapper = new ClashCollectResultWrapper( dependencyService.getDependencyTree( artifact, this.getRepoSession(), this.getRepoSystem(), this.getIncludedScopesList(), this.getExcludedScopesList(), this.isIncludeOptional() ) );

      htmlVisualizer.visualize( clashCollectResultWrapper, this.getSeverity(), this );


    } catch ( IllegalArgumentException e ) {
      throw new MojoFailureException( e.getMessage(), e );
    }

  }
}
