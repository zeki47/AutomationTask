package pages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAPI {

    public String GetCurrencyInfo(String countryCode) {

        RestAssured.useRelaxedHTTPSValidation();

        // Set base URI for API
        RestAssured.baseURI = "https://restcountries.com/v3.1";

        // Make GET request to retrieve user details
        Response response = given().accept(ContentType.JSON).and()
                .pathParam("countryCode", countryCode).when().get("/alpha/{countryCode}");
        System.out.println("Status received => " + response.getStatusLine());
        //System.out.println("Response=>" + response.prettyPrint());

        JsonPath jsonPath = response.jsonPath();
        String currency;

        // Extract currency name
        switch(countryCode) {
            case "GB":
                currency = jsonPath.getString("currencies.GBP.name");
                break;
            case "CH":
                currency = jsonPath.getString("currencies.CHF.name");
                break;
            default:
                currency = "US Dollar";
        }

        currency = currency.substring(1,currency.length()-1);

        return currency;
    }
}
