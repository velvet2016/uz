import config.Config;
import enums.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.SearchPage;
;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


public abstract   class AbstractTest {
    protected static WebDriver driver;

    @BeforeSuite
    public static void setUp() {
        driver = Browser.valueOf(Config.BROWSER).getDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public static void tearDown() {
        driver.quit();
    }

    protected SearchPage loadUz() {
        driver.get(Config.URL);

            return new SearchPage(driver);

    }

//    private boolean isProfileIconPresented(WebDriver driver) {
//        int size = driver.findElements(By.xpath(".//*[@id='user-nav']/div/div[1]")).size();
//        return size > 0;
//    }

    protected String getRandomString() {
        return UUID.randomUUID().toString();
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException
    {
        if (true/*testResult.getStatus() == ITestResult.FAILURE  && driver!=null*/) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("target/screenshots/"+testResult.getName()+".jpg"));
        }
    }
}