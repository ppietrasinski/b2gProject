//package tests;
//
//import org.assertj.core.api.Assertions;
//import org.testng.annotations.Test;
//import page.objects.FilteredProductsListPage;
//import page.objects.MainPage;
//
//import java.util.List;
//
//
//public class CopyAllegroSearchTest extends TestBase {
//
//    String searchedProduct = "iPhone 11";
//    int percentValue = 23;
//    List<String> listOfPricesAsString;
//
//    @Test(priority = 0)
//    public void getListOfPricesTest() {
//
//        MainPage mainPage = new MainPage();
//        mainPage.closeInformationPopUp()
//                .searchForProductInSearchInput(searchedProduct)
//                .selectBlackColorFilter();
//
//        FilteredProductsListPage filteredPlp = new FilteredProductsListPage();
//        listOfPricesAsString = filteredPlp.getListOfPrices();
//
//        Assertions.assertThat(filteredPlp.isBlackFilterVisible()).isTrue();
//
//    }
//
//    @Test(priority = 1)
//    public void valuesTest() {
//
//        TestHelpers helpers = new TestHelpers();
//
//        int amountOfProductsSearched = helpers.getAmountOfElementsFromTheList(listOfPricesAsString);
//        Double highestPrice = helpers.getHighestPriceAsDoubleFromThePricesList(listOfPricesAsString);
//        Double multipliedHighestValue = helpers.addPercentValueToDouble(percentValue, highestPrice);
//
//        System.out.println("\namount of searched products matching the criteria:");
//        System.out.println("1. searched item: " + searchedProduct + "\n2. filtered color: black -> " + amountOfProductsSearched + " products");
//
//        System.out.println("\nhighest price from the list: " + highestPrice);
//        System.out.println("highest price multiplied by " + percentValue + "%: " + multipliedHighestValue);
//
//        Assertions.assertThat(amountOfProductsSearched).isNotEqualTo(0);
//        Assertions.assertThat(highestPrice).isLessThan(multipliedHighestValue);
//
//    }
//}
