package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchPage extends PageObject {
    @FindBy(name = "from-title")
    private WebElement inputFrom;

    @FindBy(name = "to-title")
    private WebElement inputTo;




    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void isLoaded() {

    }

    @Override
    protected String getExpectedTitle() {
        return "Online reservation and purchase tickets - Ukrzaliznytsia";
    }

    public void setFrom(String input){
        inputFrom.sendKeys(input);
    }

    public void setCityFrom(String input){
        inputFrom.sendKeys(input);
        waitForPresense(By.xpath("//ul[@id='ui-id-1']/li[text()='"+input+"']"));

    }
    public void setCityTo(String input){
        inputTo.click();
        inputTo.sendKeys(input);
        waitForPresense(By.xpath("//ul[@id='ui-id-2']/li[text()='"+input+"']"));
    }
}
