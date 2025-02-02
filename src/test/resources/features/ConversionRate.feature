Feature: Check Conversion Rate

  Scenario Outline: Check Conversion Rate is greater than 1
    Given user retrieves "<Country Code>" currency info from the API
    When user navigates Oanda and selects currency unit
    Then verify that conversion rate is greater than 1
    Examples:
    |Country Code|
    |GB          |
    |CH          |
