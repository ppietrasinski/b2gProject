package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsListPage {

    private Logger logger = LogManager.getRootLogger();

    public ProductsListPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @FindBy(xpath = "//label[@class='_u2xi2 _1xzdi _1wulo _1vzz9 _3e3a8_3Bcvi']/span[text()='czarny']")
    private WebElement blackColorFilter;

    public FilteredProductsListPage selectBlackColorFilter() {
        logger.info("selecting black color filter");
        blackColorFilter.click();
        return new FilteredProductsListPage();
    }

}
