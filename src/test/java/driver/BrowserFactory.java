package driver;

import configuration.LocalWebDriverProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    private static String currentUserProjectDir = System.getProperty("user.dir");

    private static final String MESSAGE_UNKNOWN_BROWSER = "Unknown browser type! Please check your configuration";

    private BrowserType browserType;

    public BrowserFactory(BrowserType browserType) {
        this.browserType = browserType;
    }

    public static WebDriver getBrowser(BrowserType browserType) {

        switch(browserType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", currentUserProjectDir + LocalWebDriverProperties.getChromeWenDriverLocation());

                return new ChromeDriver();
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", currentUserProjectDir + LocalWebDriverProperties.getFirefoxDriverLocation());

                return new FirefoxDriver();
            default:
                throw new IllegalStateException(MESSAGE_UNKNOWN_BROWSER);
        }
    }
}
