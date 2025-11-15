import java.util.Map;
import java.util.*;

interface ApplicationInstaller{
    String install(String appName);
}
class RealApplicationInstaller implements ApplicationInstaller{
    @Override
    public String install(String appName){
        // System.out.println("Installing application: " + appName);
        return "Application " + appName + " installed successfully.";
    }
}
class CachedApplicationInstaller implements ApplicationInstaller{
    private RealApplicationInstaller realApplicationInstaller;
    private Map<String, String> cache;
    public CachedApplicationInstaller(){
        this.realApplicationInstaller = new RealApplicationInstaller();
        this.cache = new HashMap<>();
    }
    @Override
    public String install(String appName){
        if(cache.containsKey(appName)){
            System.out.println("Fetching installation info from cache for app: " + appName);
            return cache.get(appName);
        }
        System.out.println("Installing application: " + appName);
        String installInfo = realApplicationInstaller.install(appName);
        cache.put(appName, installInfo);
        return installInfo;
    }
}
public class P {
    public static void main(String[] args) {
        ApplicationInstaller installer = new CachedApplicationInstaller();
        installer.install("MyApp");
        installer.install("MyApp2");
    }
}
