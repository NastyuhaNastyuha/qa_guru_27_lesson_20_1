package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources("classpath:browserstack.properties")
public interface BrowserstackConfig extends Config {

    @Key("browserstack.url")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String getBrowserstackUrl();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getOsVersion();

    @Key("app")
    String getApp();
}