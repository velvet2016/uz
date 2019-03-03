package enums;

import config.Config;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

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
    }, HTML_UNIT {
        public WebDriver getDriver() {
            return new ScreenCaptureHtmlUnitDriver(true);
        }
    };

    public abstract WebDriver getDriver();
}
