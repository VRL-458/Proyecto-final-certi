Feature: Cart feature
  Background: The infomration obout the carrito
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button


  Scenario: Check that the cart does not have to be empty
      When I click on the cart button
      Then The cart should no be empty

  Scenario: Check the products added on the cart
    Then I order some products "Sauce Labs Backpack"
    Then I order some products "Sauce Labs Bike Light"
    Then Check the products name




