package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:classpath:emulation.properties",
})
public interface LocalMobileDriverConfig extends Config {
    String url();
    String platformName();
    String deviceName();
    String automationName();
    String app();
    String appWaitPackage();
    String appWaitActivity();
}