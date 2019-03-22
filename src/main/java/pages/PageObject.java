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
            throw new IllegalStateException("Page was not loaded. Expected page title " + getExpectedTitle() + " \nbut actual: " + actualTitle);
        }
        logger.info("checking page title: Success");
        logger.info("Page loaded: " + this.getClass().getSimpleName());
    }

    abstract protected void isLoaded();

    private final Logger logger = Logger.getLogger(this.getClass());


    protected WebElement waitForPresense(By by, int secondToWait) throws Error {
        logger.debug("waiting till element " + by.toString() + " loaded");
        WebElement elementToWait = new WebDriverWait(driver, secondToWait)
                .until(ExpectedConditions.presenceOfElementLocated(by));
        logger.debug("waiting till element " + by.toString() + " loaded...Done");
        return elementToWait;
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

