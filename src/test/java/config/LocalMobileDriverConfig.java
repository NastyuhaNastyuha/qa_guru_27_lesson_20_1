package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:classpath:emulation.properties",
})
public interface LocalMobileDriverConfig extends Config {
    @Key("url")
    String url();

    @Key("platformName")
    String platformName();

    @Key("deviceName")
    String deviceName();

    @Key("automationName")
    String automationName();

    @Key("app")
    String app();

    @Key("appWaitPackage")
    String appWaitPackage();

    @Key("appWaitActivity")
    String appWaitActivity();
}