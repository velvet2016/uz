import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.SearchPage;

@Listeners(ListenerClass.class)
public class Test1 extends AbstractTest{

    @Test
    public void testKyivOdesa(){
        SearchPage searchPage = loadUz();
        searchPage.setCityFrom("Kyiv");
        searchPage.setCityTo("Odesa");
    }
}
