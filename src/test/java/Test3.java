import config.Config;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.SearchPageSimple;

public class Test3 extends AbstractTest {

    @Test
    public void testKyivOdesa() {
        driver.get(Config.URL);
        SearchPageSimple searchPage = new SearchPageSimple(driver);
        searchPage.setCityFrom("Kyiv");
    }
}
