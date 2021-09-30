package RozetkaTest.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private final SelenideElement phonesElectronicsTvSectionCSS = $(byCssSelector("body > app-root > div > " +
            "div > rz-main-page > div > aside > main-page-sidebar " +
            "> sidebar-fat-menu > div > ul > li:nth-child(2) > a"));


    /**
     * Method for moving to Phones, TV, Electronics page
     */

    public void moveToPhonesTvElectronicsSection() {
        $("body > app-root > div > div > rz-main-page > " +
                "div > aside > main-page-sidebar > sidebar-fat-menu > div")
                .should(Condition.exist, Duration.ofSeconds(6000));
        phonesElectronicsTvSectionCSS.click();
    }
}

