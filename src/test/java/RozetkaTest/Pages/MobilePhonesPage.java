package RozetkaTest.Pages;

import com.codeborne.selenide.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.elements;

public class MobilePhonesPage {

    public String mainArticle = "Мобильные телефоны";

    /**
     * Method for a getting current main article
     */

    public String getMainArticle() {
        return $(byCssSelector("body > app-root > div > div " +
                "> rz-category > div > main > div:nth-child(1) > div > h1"))
                .getText();
    }


    /**
     * Method for parsing all prices of products from 1 page. Return list of Integer.
     */


    private List<Integer> parseAllPrices() {

        $("body > app-root > div > div > rz-category > div > main > rz-catalog > div > div > section")
                .should(Condition.exist, Duration.ofSeconds(8000));

        List<String> stringListOfPrices = new ArrayList<>();
        List<Integer> integerListOfPrices;
        ElementsCollection collectionOfPrices;

        collectionOfPrices = elements(byClassName("goods-tile__price-value"));

        for (SelenideElement collect : collectionOfPrices) {
            String prices = collect.getText();
            stringListOfPrices.add(prices.replaceAll("\\s+", ""));
        }

        integerListOfPrices = stringListOfPrices
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return integerListOfPrices;
    }


    /**
     * Method for getting List of parsed prices. Return Integer List.
     */

    public List<Integer> getAllParsedPrices() {
        $("body > app-root > div > div > rz-category > div > main > rz-catalog > div > div > section")
                .should(Condition.exist, Duration.ofSeconds(8000));
        return parseAllPrices();
    }


    /**
     * Method for sorting parsed List of product via Collection, to make sure that list is sort by DESC.
     * Return List of Integer.
     */
    public List<Integer> sortCollectionByDescAuto() {  //Сорт DESC программно мной
        $("body > app-root > div > div > rz-category > div > main > rz-catalog > div > div > section")
                .should(Condition.exist, Duration.ofSeconds(8000));

        List<Integer> sortedByDESC = new ArrayList<>(getAllParsedPrices());
        Collections.sort(sortedByDESC);
        Collections.reverse(sortedByDESC);
        return sortedByDESC;
    }


    /**
     * Method for set filter by price DESC. Return MobilePhonesPage object.
     */
    public MobilePhonesPage setPriceByDescFilter() { //Сорт ДЕСК
        $(byCssSelector("body > app-root > div > div > rz-category >" +
                " div > main > rz-catalog > div > rz-catalog-settings > div > rz-sort > select"))
                .should(Condition.exist, Duration.ofSeconds(5000));

        $(byCssSelector("body > app-root > div > div > rz-category > div > main > " +
                "rz-catalog > div > rz-catalog-settings > div > rz-sort > select"))
                .find("body > app-root > div > div > rz-category > div > main > rz-catalog >" +
                        " div > rz-catalog-settings > div > rz-sort > select > option:nth-child(3)")
                .click();
        return this;
    }


    /**
     * Method for set filter by price DESC and return sorted prices. Return List of Integer.
     */
    public List<Integer> parsePricesAfterSortByDESC() {
        return setPriceByDescFilter().parseAllPrices();

    }

 //Парс с плашки
    public List<String> parseAllPrice1s() {
        List<String> stringListOfPrices = new ArrayList<>();
        String str = " Акция ";
        ElementsCollection collection = elements(byClassName("goods-tile__label"));
        for (SelenideElement collect : collection) {
            String prices = collect.getText();
            stringListOfPrices.add(prices);
        }
        return stringListOfPrices;
    }

}


