package RozetkaTest.Tests;

import RozetkaTest.Pages.HomePage;
import RozetkaTest.Pages.MobilePhonesPage;
import RozetkaTest.Pages.PhonesTvElectronicsPage;
import RozetkaTest.SelenideProperties.TestProperties;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestStockPrices extends TestProperties {


    @Test(groups = "prices")
    public void sortedPricesToFile() {

        HomePage homePage = new HomePage();
        PhonesTvElectronicsPage phonesTvElectronicsPage = new PhonesTvElectronicsPage();
        MobilePhonesPage mobilePhonesPage = new MobilePhonesPage();

        homePage.moveToPhonesTvElectronicsSection();
        phonesTvElectronicsPage.moveToMobilesSection();

        assertion.assertEquals(mobilePhonesPage.getMainArticle(), mobilePhonesPage.mainArticle);

        mobilePhonesPage.sortCollectionByDescAuto();
        mobilePhonesPage.parsePricesAfterSortByDESC();

        assertion.assertEquals(mobilePhonesPage.sortCollectionByDescAuto(), mobilePhonesPage.parsePricesAfterSortByDESC());

        List<Integer> list = new ArrayList<>(mobilePhonesPage.parsePricesAfterSortByDESC()); //Запись в файл отсортированного листа DESC


        try {
            File file = new File("C:\\autodoc\\result.txt");
            PrintWriter pw = new PrintWriter(file);

            for (Integer listOfPrices : list) {
                pw.println(listOfPrices);
            }
            pw.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }

    }
}

