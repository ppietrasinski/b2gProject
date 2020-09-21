package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

import java.util.List;
import java.util.stream.Collectors;

public class FilteredProductsListPage {

    private Logger logger = LogManager.getRootLogger();

    public FilteredProductsListPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @FindBy(xpath = "//div[@class='_9c44d_3AMmE']//span[@class='_1svub _lf05o']")
    private List<WebElement> listOfProducts;

    @FindBy(xpath = "//span[contains(@class, 'mgmw_ag') and text()='Kolor']")
    private WebElement colorFilterButton;

    public List<String> getListOfPrices() {
        logger.info("get list of products prices");
        WaitForElement.waitUntilElementIsVisible(colorFilterButton);
        return listOfProducts.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public boolean isBlackFilterVisible() {
        return colorFilterButton.isDisplayed();
    }

}
