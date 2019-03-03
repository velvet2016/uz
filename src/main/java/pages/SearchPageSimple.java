package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageSimple extends PageObject {
    public SearchPageSimple(WebDriver driver) {
        super(driver);
    }


    @Override
    protected void isLoaded() {

    }

    @Override
    protected String getExpectedTitle() {
        return SearchPage.TITLE;
    }

    public void setCityFrom(String input) {
        WebElement inputFrom = driver.findElement(By.name("from-title"));
        inputFrom.sendKeys(input);
        waitForPresense(By.xpath("//ul[@id='ui-id-1']/li[text()='" + input + "']"));
    }

}
