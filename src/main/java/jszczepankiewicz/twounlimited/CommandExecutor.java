package jszczepankiewicz.twounlimited;

import org.apache.commons.exec.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author jszczepankiewicz
 * @since 2018-03-17
 */
public class CommandExecutor {

  /**
   * Execute command synchronously, cast stdout to integer and return it. It will block max for 5 seconds after which
   * execution of underlying command will break.
   *
   * @param command
   * @return
   * @throws RuntimeException exit code !=0 or stderr not empty.
   */
  public int execute(String command, String... args) throws RuntimeException, IOException {

    CommandLine cmdl = new CommandLine(command);

    for (String arg : args) {
      cmdl.addArgument(arg);
    }

    ExecuteWatchdog watchdog = new ExecuteWatchdog(5 * 1000);
    Executor executor = new DefaultExecutor();
    executor.setExitValue(0);
    executor.setWatchdog(watchdog);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
    executor.setStreamHandler(streamHandler);

    int exitValue = executor.execute(cmdl);
    String outcome = outputStream.toString();

    if (outcome.isEmpty()) {
      throw new IllegalStateException("Expected command [" + command + "] with optional args to return non empty result but finished successfully without outcome");
    }

    int result = Integer.valueOf(outcome.trim());
    return result;
  }
}
