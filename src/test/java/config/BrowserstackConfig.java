package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:browserstack.properties")
public interface BrowserstackConfig extends Config {
    @Key("browserstack.user")
    String getUser();

    @Key("browserstack.key")
    String getKey();

    @Key("browserstack.url")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String getBrowserstackUrl();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();


    @DefaultValue("bs://9f6b0541fb356362e55f83c0472054854ff94024")
    String browserstackApp();

    @DefaultValue("Google Pixel 7")
    String browserstackDevice();

    @DefaultValue("13.0")
    String browserstackPlatform();

    String automationName();

    String platformName();

    String appLanguage();

    String appLocale();

    Boolean appFullReset();

    String browserstackUrl();
}