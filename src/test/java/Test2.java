import org.testng.annotations.Test;
import pages.SearchPage;

public class Test2 extends AbstractTest{

    @Test
    public void testKyivLviv(){
        SearchPage searchPage = loadUz();
        searchPage.setCityFrom("Kyiv");
        searchPage.setCityTo("Lviv");
    }
}
