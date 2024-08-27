package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:config/${deviceHost}.properties",
        "file:~/config/${deviceHost}.properties"
})

public interface LocalMobileDriverConfig extends Config {

    String automationName();

    String deviceName();

    String platformName();

    String appPackage();

    String appActivity();

    String appVersion();

    String appLanguage();

    String appLocale();

    Boolean appFullReset();

    String appUrl();

    @DefaultValue("http://localhost:4723/wd/hub")
    String appiumUrl();

}