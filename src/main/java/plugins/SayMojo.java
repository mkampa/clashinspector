package plugins;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Created with IntelliJ IDEA.
 * User: Martin
 * Date: 31.10.13
 * Time: 23:59
 * To change this template use File | Settings | File Templates.
 */

/**
 * Echos an object string to the output screen.
 * @goal say
 * @requiresProject true
 * !Annotationen nicht im Kommentar
 */

//@Mojo (name="say", requiresProject="true")      //mit STR + Leer hilft IDEA
public class SayMojo extends AbstractMojo{

  /**
   * Any Object to print out.
   * @parameter expression="${say.message}" default-value="Hello World!"
   */
  private Object message;

  public void execute() throws MojoExecutionException, MojoFailureException{
    getLog().info(message.toString());
  }
}
