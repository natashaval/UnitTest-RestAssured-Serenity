Feature: As a user, I want to check zomato API

  @ApiTest
  Scenario: As a user, I want to get category
    Given user prepare request
    When user hit on api categories
    Then id "1" should be "Delivery"