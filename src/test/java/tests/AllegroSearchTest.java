package tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import page.objects.FilteredProductsListPage;
import page.objects.MainPage;
import java.util.List;


public class AllegroSearchTest extends TestBase
{

    @Test
    public void firstAllegroTest() {

        String searchedProduct = "iPhone 11";
        int percentValue = 23;

        MainPage mainPage = new MainPage();
        mainPage.closeInformationPopUp()
                .searchForProductInSearchInput(searchedProduct)
                .selectBlackColorFilter();

        FilteredProductsListPage filteredPlp = new FilteredProductsListPage();
        List<String> listOfPricesAsString = filteredPlp.getListOfPrices();

        Assertions.assertThat(filteredPlp.isBlackFilterVisible()).isTrue();

        TestHelpers helpers = new TestHelpers();
        int amountOfProductsSearched = helpers.getAmountOfElementsFromTheList(listOfPricesAsString);
        Double highestPrice = helpers.getHighestPriceAsDoubleFromThePricesList(listOfPricesAsString);
        Double multipliedHighestValue = helpers.addPercentValueToDouble(percentValue, highestPrice);

        Assertions.assertThat(amountOfProductsSearched).isNotEqualTo(0);
        Assertions.assertThat(highestPrice).isLessThan(multipliedHighestValue);

        System.out.println("\namount of searched products matching the criteria:");
        System.out.println("1. searched item: " + searchedProduct + "\n2. filtered color: black\nresult: " + amountOfProductsSearched + " products");

        System.out.println("\nhighest price from the list: " + highestPrice);
        System.out.println("highest price multiplied by " + percentValue + "%: " + multipliedHighestValue + "\n");

    }

}
