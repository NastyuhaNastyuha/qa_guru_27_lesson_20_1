package config;

import com.codeborne.selenide.Configuration;
import drivers.BrowserstackDriver;
import drivers.LocalMobileDriver;

public class LocalMobileDriverReader {
    public void setLocalMobileDriverConfig() {
        String deviceHost = System.getProperty("deviceHost");
        Configuration.browserSize = null;
        if ((deviceHost == null) || deviceHost.equals("browserstack")) {
            Configuration.browser = BrowserstackDriver.class.getName();
        } else {
            Configuration.browser = LocalMobileDriver.class.getName();
        }
    }
}