package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.OandaHomePage;
import pages.RestAPI;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;


public class ConversionRateStepDefinitions {
    private String currency;
    private String ConversionRateStr;
    private WebDriver driver;

    @Given("user retrieves {string} currency info from the API")
    public void user_retrieves_currency_information_from_the_API(String CountryCode){
        RestAPI restAPI = new RestAPI();
        currency = restAPI.GetCurrencyInfo(CountryCode);
    }

    @When("user navigates Oanda and selects currency unit")
    public void user_navigates_Oanda_and_selects_currency_unit() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        OandaHomePage oandaHomePage = new OandaHomePage(driver);
        ConversionRateStr = oandaHomePage.FindConversionRate(currency);
    }

    @Then("verify that conversion rate is greater than 1")
    public void verify_that_conversion_rate_is_greater_than_1() throws InterruptedException {
        BigDecimal ConversionRate = new BigDecimal(ConversionRateStr);
        BigDecimal threshold = BigDecimal.ONE;
        Assert.assertTrue(ConversionRate.compareTo(threshold)<0);

        Thread.sleep(2000);
        if (driver != null) {
            driver.quit();
        }

    }

}
