package enums;

import config.Config;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public enum Browser {
    FIREFOX {
        public WebDriver getDriver() {
            System.setProperty(Config.FIREFOX_WEBDRIVER_SYSTEM_PROPERTY, Config.FIREFOX_DRIVER_PATH);
            return new FirefoxDriver();
        }
    }, CHROME {
        public WebDriver getDriver() {
            System.setProperty(Config.CHROME_WEBDRIVER_SYSTEM_PROPERTY, Config.CHROME_DRIVER_PATH);
            return new ChromeDriver();
        }

    }, CHROME_HEADLESS {
        public WebDriver getDriver() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setHeadless(true);
            System.setProperty(Config.CHROME_WEBDRIVER_SYSTEM_PROPERTY, Config.CHROME_DRIVER_PATH);
            return new ChromeDriver(chromeOptions);
        }

    }, HTML_UNIT {
        public WebDriver getDriver() {
            HtmlUnitDriver htmlUnitDriver = new HtmlUnitDriver(true);
            return htmlUnitDriver;
        }
    }, PHANTOM {
        public WebDriver getDriver() {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, Config.PHANTOM_DRIVER_PATH);
            capabilities.setJavascriptEnabled(true);
            capabilities.setBrowserName(BrowserType.CHROME);
            capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, "--webdriver-loglevel=ERROR");
            return new PhantomJSDriver(capabilities);
        }
    };

    public abstract WebDriver getDriver();
}
