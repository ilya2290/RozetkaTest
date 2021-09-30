package RozetkaTest.SelenideProperties;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.Assertion;

import static com.codeborne.selenide.Selenide.open;

public class TestProperties {
    public Assertion assertion = new Assertion();

    @BeforeClass
    public void driverInit() {
        Configuration.startMaximized = true;
        open("https://rozetka.com.ua/");


    }

}
