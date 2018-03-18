package jszczepankiewicz.twounlimited;

import org.junit.Test;

import static jszczepankiewicz.twounlimited.PlatformTestsHelper.isLinux;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;


/**
 * @author jszczepankiewicz
 * @since 2018-03-17
 */
public class CommandExecutorTest {



  @Test
  public void returnIntegerForPositiveCommandLaunchOnWindows() throws Exception {

    if (isLinux()) {
      //  ignoring platform specific tests
      return;
    }
    //  given
    String command = "cmd";
    CommandExecutor executor = new CommandExecutor();

    //  when
    int result = executor.execute(command, "/C", "echo", "99");

    //  then
    assertThat(result).isEqualTo(99);
  }

  @Test
  public void returnIntegerForPositiveCommandLaunchOnLinux() throws Exception {

    //  given
    if (!isLinux()) {
      //  ignoring platform specific tests
      return;
    }

    String command = "echo";
    CommandExecutor executor = new CommandExecutor();

    //  when
    int result = executor.execute(command, "99");

    //  then
    assertThat(result).isEqualTo(99);
  }

}