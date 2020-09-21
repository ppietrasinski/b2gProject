package page.objects;


import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class MainPage {

    private Logger logger = LogManager.getRootLogger();

    public MainPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @FindBy(xpath = "//button[contains(text(), 'dalej')]")
    private WebElement closeInformationPopUpButton;

//    //button[contains(text()='dalej')]

    @FindBy(name = "string")
    private WebElement searchInput;

    @FindBy(id = "suggestion-0")
    private WebElement firstSuggestion;

    public MainPage closeInformationPopUp() {
        logger.info("trying to close information popup");
        WaitForElement.waitUntilElementIsClickable(closeInformationPopUpButton);
        closeInformationPopUpButton.click();
        logger.info("clicked closeInformationPopUp button");
        return this;
    }

    public ProductsListPage searchForProductInSearchInput(String searchedProductName) {
        logger.info("trying to search for " + searchedProductName + " product");
        WaitForElement.waitUntilElementIsClickable(searchInput);
        searchInput.sendKeys(searchedProductName);
        firstSuggestion.click();
        logger.info("clicked on the first suggestion found");
        return new ProductsListPage();
    }

}
