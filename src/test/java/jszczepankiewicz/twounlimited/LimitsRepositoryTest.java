package jszczepankiewicz.twounlimited;


import org.junit.Test;

import static java.util.Arrays.asList;
import static jszczepankiewicz.twounlimited.PlatformTestsHelper.isLinux;

/**
 * @author jszczepankiewicz
 * @since 2018-03-17
 */
public class LimitsRepositoryTest {

  private LimitsRepository repo = getLinuxLimitsRepository();

  @Test
  public void retrieveAllTheLimitsValuesOnLinux(){

    //  given
    if (!isLinux()) {
      //  ignoring platform specific tests
      return;
    }

    //  when
    int maxProcesses = repo.getLimitForProcessesOfCurrentUser();
    int maxFileHandlers = repo.getLimitForFileAndSocketsOfCurrentUser();

    System.out.println("max processes: " + maxProcesses);
    System.out.println("max files and sockets: " + maxFileHandlers);
  }

  @Test
  public void retrievePopulationValuesOnLinux(){

    //  given
    if (!isLinux()) {
      //  ignoring platform specific tests
      return;
    }
  }


  private LimitsRepository getLinuxLimitsRepository(){
    return new LimitsRepository(
            "ulimit", asList("-u"),
            "ulimit", asList("-Sn"),
            "bash", asList("-c", "lsof | wc -l"),         //  https://www.cyberciti.biz/tips/linux-procfs-file-descriptors.html
            currentFileAndSocketsPopulationCommand, //  https://stackoverflow.com/questions/3874677/the-number-of-processes-a-user-is-running-using-bash
            );
  }

}