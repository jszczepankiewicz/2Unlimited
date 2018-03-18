package jszczepankiewicz.twounlimited;

/**
 * @author jszczepankiewicz
 * @since 2018-03-17
 */
public class PlatformTestsHelper {
  /**
   * we check for linux assuming not linux is windows. This is easier than rely on windows checking,
   * see i.e. https://stackoverflow.com/questions/31909107/javas-os-name-for-windows-10/31909887#31909887
   *
   * @return
   */
  public static boolean isLinux() {
    String os = System.getProperty("os.name").toLowerCase();
    return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("aix") > 0);
  }
}
