package configuration;

import driver.BrowserType;

public class LocalWebDriverProperties {

    public static BrowserType getLocalBrowser() {
        return BrowserType.valueOf(ConfigurationProperties.getProperties().getProperty("local.browser"));
    }

    public static String getChromeWenDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("chrome.driver.location");
    }

    public static String getFirefoxDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("firefox.driver.location");
    }

}
