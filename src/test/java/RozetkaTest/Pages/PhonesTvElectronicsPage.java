package RozetkaTest.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class PhonesTvElectronicsPage {

    private final SelenideElement mobilePhonesSectionItem = $(byCssSelector("body > app-root > div > div " +
            "> rz-super-portal > div > main > section > div:nth-child(3) > rz-dynamic-widgets " +
            "> rz-widget-list:nth-child(3) > section > ul > li:nth-child(1)"));


    /**
     * Method to moving to the Mobile Section
     */

    public void moveToMobilesSection() {
        $("body > app-root > div > div > rz-super-portal > div > main > section > div:nth-child(3)" +
                " > rz-dynamic-widgets > rz-widget-list:nth-child(3) > section > ul")
                .should(Condition.exist, Duration.ofSeconds(4000));
        mobilePhonesSectionItem.click();
    }


}
