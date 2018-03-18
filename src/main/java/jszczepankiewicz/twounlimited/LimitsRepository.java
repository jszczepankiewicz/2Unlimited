package jszczepankiewicz.twounlimited;

import java.util.List;

/**
 * @author jszczepankiewicz
 * @since 2018-03-17
 */
public class LimitsRepository {

  private final String maxProcessCommand;
  private final List<String> maxProcessCommandArgs;
  private final String maxFileAndSocketsCommand;
  private final List<String> maxFileAndSocketsCommandArgs;
  private final String currentProcessPopulationCommand;
  private final List<String> currentProcessPopulationCommandArgs;
  private final String currentFileAndSocketsPopulationCommand;
  private final List<String> currentFileAndSocketsPopulationCommandArgs;

  public LimitsRepository(String maxProcessCommand, List<String> maxProcessCommandArgs,
                          String maxFileAndSocketsCommand, List<String> maxFileAndSocketsCommandArgs,
                          String currentProcessPopulationCommand, List<String> currentProcessPopulationCommandArgs,
                          String currentFileAndSocketsPopulationCommand, List<String> currentFileAndSocketsPopulationCommandArgs) {

    this.maxProcessCommand = maxProcessCommand;
    this.maxProcessCommandArgs = maxProcessCommandArgs;
    this.maxFileAndSocketsCommand = maxFileAndSocketsCommand;
    this.maxFileAndSocketsCommandArgs = maxFileAndSocketsCommandArgs;
    this.currentProcessPopulationCommand = currentProcessPopulationCommand;
    this.currentProcessPopulationCommandArgs = currentProcessPopulationCommandArgs;
    this.currentFileAndSocketsPopulationCommandArgs = currentFileAndSocketsPopulationCommandArgs;
    this.currentFileAndSocketsPopulationCommand = currentFileAndSocketsPopulationCommand;
  }

  public int getLimitForProcessesOfCurrentUser() {
    return -100;
  }

  public int getLimitForFileAndSocketsOfCurrentUser() {
    return -100;
  }

  public int getCurrentNumberOfProcessesForCurrentUser() {
    return -100;
  }

  public int getNumberOfFileAndSocketsForCurrentUser() {
    return -100;
  }


}
