import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class testFile {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "D:/Programowanie/SeleniumJava/b2bNetworkRecProject/tools/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void firstAllegroTest() throws InterruptedException {

        driver.navigate().to("https://allegro.pl/");

        WebElement closeInformationPopUp = driver.findElement(By.xpath("//button[text()='przejdź dalej']"));
        closeInformationPopUp.click();

        WebElement searchInput = driver.findElement(By.name("string"));
//        WebElement searchButton = driver.findElement(By.xpath("//button[@class='_13q9y _8tsq7 _1q2ua mr3m_0 mli2_0 mh85_0 mh85_56_m msbw_0 mtag_0']"));

        searchInput.sendKeys("iPhone 11");
//        searchButton.click();

        WebElement suggestionZero = driver.findElement(By.id("suggestion-0"));
        suggestionZero.click();

        Thread.sleep(1500);

        WebElement blackFilter = driver.findElement(By.xpath("//label[@class='_u2xi2 _1xzdi _1wulo _1vzz9 _3e3a8_3Bcvi']/span[text()='czarny']"));
        blackFilter.click();

        Thread.sleep(3000);

        List<WebElement> listOfProducts = driver.findElements(By.xpath("//div[@class='_9c44d_3AMmE']//span[@class='_1svub _lf05o']"));

        List<String> listOfProductsPrices = listOfProducts.stream()
                .map(e -> e.getText())
                .collect(Collectors.toList());

        List<String> changedListOfPrices = listOfProductsPrices.stream()
                .map(e -> e.toString().replaceAll("\\s+", "").replace(",","."))
                .map(s -> s.substring(0, s.length() - 2))
                .collect(Collectors.toList());

        List<Double> pricesAsDoubleList = changedListOfPrices.stream()
                .map(Double::valueOf)
                .collect(Collectors.toList());

        Double highestPrice = pricesAsDoubleList.stream()
                .max(Double::compareTo)
                .get();

        Double newHighestPrice = Math.round(highestPrice * 1.23 * 100)/100.0d;

        System.out.println(Arrays.toString(listOfProductsPrices.toArray()));
        System.out.println("\nprodukty: " + listOfProducts.size());
        System.out.println("ilość cen produktów: " + listOfProductsPrices.size());

        System.out.println(Arrays.toString(changedListOfPrices.toArray()));

        System.out.println("najwyższa cena: " + highestPrice);
        System.out.println("najwyższa cena + 23%: " + newHighestPrice);

        driver.close();
        driver.quit();

    }

}
