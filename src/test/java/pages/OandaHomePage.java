package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OandaHomePage {
private WebDriver driver;
public OandaHomePage(WebDriver driver) {
    this.driver = driver;
}

    public String FindConversionRate(String currency) throws InterruptedException {

        driver.get("https://www.oanda.com/currency-converter/en/");

        System.out.println(driver.getTitle());

        WebElement dropdownCurrency = driver.findElement(By.id("quoteCurrency_currency_autocomplete"));

        dropdownCurrency.click();

        dropdownCurrency.sendKeys(currency);

        dropdownCurrency.sendKeys(Keys.ARROW_DOWN);

        dropdownCurrency.sendKeys(Keys.RETURN);

        Thread.sleep(3000);

        WebElement textConversionRate = driver.findElement(By.xpath("//input[@tabindex='4']"));

        String ConversionRateStr = textConversionRate.getAttribute("value");

        System.out.println(ConversionRateStr);

        return ConversionRateStr;


    }
}
