package pages;

import config.Config;
//import org.apache.log4j.Logger;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class PageObject {
    protected WebDriver driver;

    public PageObject(WebDriver driver) {
        logger.info("loading page: " + this.getClass().getSimpleName());
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logger.info("chekcing page title");
        String actualTitle = driver.getTitle();
        if (isCheckTitleNeeded() && !actualTitle.equals(getExpectedTitle())) {
            throw new IllegalStateException("Page was not loaded. Expected page title " + getExpectedTitle() + "but actual: " + actualTitle);
        }
        logger.info("chekcing page title: Success");
        logger.info("Page loaded: " + this.getClass().getSimpleName());
    }

    abstract protected void isLoaded();

    private final Logger logger = Logger.getLogger(this.getClass());


    protected void waitForPresense(By by) throws Error {
        logger.debug("waiting till element " + by.toString() + " loaded");
        new WebDriverWait(driver, Config.EXPLICIT_WAIT_SMALL).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private void waitForVisibilityWithSmallWait(WebElement element) {
        int secondsToWait = Config.EXPLICIT_WAIT_SMALL;
        String message = "waiting till element " + element.toString() + " become visible. Explicit wait = " + secondsToWait;
        logger.debug(message);
        new WebDriverWait(driver, secondsToWait).until(ExpectedConditions.visibilityOf(element));
        logger.debug(message + "...Done");
    }


    protected void logInputAction(String inputFieldName, String inputValue) {
        logger.info("typing \"" + inputValue + "\" to  \"" + inputFieldName + "\"");
    }

    protected void logClick(WebElement element) {
        logger.info("clicking  on " + "\"" + element.toString() + "\"...");
        element.click();
    }

    protected abstract String getExpectedTitle();

    protected boolean isCheckTitleNeeded() {
        return true;
    }
}

