import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.SearchPage;

@Listeners(ListenerClass.class)
public class Test2 extends AbstractTest{

    @Test
    public void testKyivLviv(){
        SearchPage searchPage = loadUz();
        searchPage.setCityFrom("Kyiv");
        searchPage.setCityTo("Lviv");
    }
}
