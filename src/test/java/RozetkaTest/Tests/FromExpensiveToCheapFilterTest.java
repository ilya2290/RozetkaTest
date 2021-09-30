package RozetkaTest.Tests;

import RozetkaTest.Pages.HomePage;
import RozetkaTest.Pages.MobilePhonesPage;
import RozetkaTest.Pages.PhonesTvElectronicsPage;
import RozetkaTest.SelenideProperties.TestProperties;
import org.testng.annotations.Test;

public class FromExpensiveToCheapFilterTest extends TestProperties {


    @Test(groups = "filtersTests") //FETC - From Expensive To Cheap
    public void filterTestFETC()  {
        HomePage homePage = new HomePage();
        PhonesTvElectronicsPage phonesTvElectronicsPage = new PhonesTvElectronicsPage();
        MobilePhonesPage mobilePhonesPage = new MobilePhonesPage();

        homePage.moveToPhonesTvElectronicsSection();

        phonesTvElectronicsPage.moveToMobilesSection();

        assertion.assertEquals(mobilePhonesPage.getMainArticle(), mobilePhonesPage.mainArticle);

        mobilePhonesPage.sortCollectionByDescAuto();
        mobilePhonesPage.parsePricesAfterSortByDESC();

        assertion.assertEquals(mobilePhonesPage.sortCollectionByDescAuto(), mobilePhonesPage.parsePricesAfterSortByDESC());

    }


}
