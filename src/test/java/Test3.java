import config.Config;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.SearchPageSimple;

@Listeners(ListenerClass.class)
public class Test3 extends AbstractTest {

    @Test
    public void testKyivOdesaSimple() {
        driver.get(Config.URL);
        SearchPageSimple searchPage = new SearchPageSimple(driver);
        searchPage.setCityFrom("Kyiv");
    }
}
