package pages;

import config.Config;
import config.Constants;
import config.PropertyReader;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;


public class SearchPage extends PageObject {
    public static final String TITLE="";

    @Override
    protected boolean isCheckTitleNeeded() {
        return false;
    }

    @FindBy(name = "from-title")
    private WebElement inputFrom;

    @FindBy(name = "to-title")
    private WebElement inputTo;

    @FindBy(xpath = "//div[@class='date']/input[@type='text']")
    private WebElement departureDateForUiUser;

    @FindBy(xpath = "//div[@class='date']/input[@type='hidden']")
    private WebElement departureDateForBackEnd;

    @FindBy(xpath = "//div[@class='date']//a[3]")
    private WebElement theDayAfter;

    @FindBy(xpath = "//div[@class='button']")
    private WebElement searchButton;


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() {

    }

    @Override
    protected String getExpectedTitle() {
        return TITLE;
    }

    public void setFrom(String input){
        inputFrom.sendKeys(input);
    }

    public void setCityFrom(String input){
        inputFrom.sendKeys(input);
        waitForPresense(By.xpath("//ul[@id='ui-id-1']/li[text()='"+input+"']"), Config.EXPLICIT_WAIT_SMALL)
                .click();

    }
    public void setCityTo(String input){
        inputTo.click();
        inputTo.sendKeys(input);
        waitForPresense(By.xpath("//ul[@id='ui-id-2']/li[text()='"+input+"']"),Config.EXPLICIT_WAIT_SMALL)
                .click();
    }

//    public void setTheDayAfter() {
//        theDayAfter.click();
//    }
    public void setDepartureDateTo(LocalDate date){
        departureDateForUiUser.click();
        Locale locale = new Locale(PropertyReader
                .getProperties(Config.LANG_PROPERTIES)
                .getProperty(Constants.PROPERTY_FILE_KEY_LANGUAGE));
        String monthName = date.getMonth().getDisplayName(TextStyle.FULL_STANDALONE,
                locale);
        String capitalizedMonthName = StringUtils.capitalize(monthName);
         waitForPresense(By.xpath(
                 "//div[@class='ui-calendar-title' and text()='"+
                         capitalizedMonthName
                         +"']/../../table//a[text()='"+
                         date.getDayOfMonth()
                         +"']"),
                 Config.EXPLICIT_WAIT_TINY)
                 .click();
    }

    public void setDepartureDateForBackEnd(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        departureDateForBackEnd.sendKeys(date.format(formatter));
        date.getMonth().getDisplayName(TextStyle.FULL, Locale.GERMAN);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickSearchForTrains(){
        searchButton.click();
    }

    public WebElement waitTillTableUpload(){
       return waitForPresense(By.xpath("//table[@class='train-table']"), Config.EXPLICIT_WAIT_SMALL);
    }
}

