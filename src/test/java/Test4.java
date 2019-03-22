import org.testng.annotations.Test;
import pages.SearchPage;

import java.time.LocalDate;

public class Test4 extends AbstractTest {
    @Test
    public void testKyivOdesaSimple() {
        SearchPage searchPage = loadUz();
        searchPage.setCityFrom("Kyiv");
        searchPage.setCityTo("Odesa");
        searchPage.setDepartureDateTo(LocalDate.now().plusMonths(1));
        searchPage.clickSearchForTrains();
        searchPage.waitTillTableUpload();

    }
}
