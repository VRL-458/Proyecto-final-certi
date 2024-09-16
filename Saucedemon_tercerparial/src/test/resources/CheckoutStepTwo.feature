Feature: Checkout Step Two feature
  Background: User login into Sauce Demo and some products added to the cart
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    Then I order some products "Sauce Labs Backpack"
    Then I order some products "Sauce Labs Bike Light"
    And I click on the cart button
    And I click on checkout button

    Scenario: Check the total price in the shop summary
      And Set the name with "Juan"
      And Set the lastname with "Garcia"
      And Set the Postal Code with "1234"
      And Click on Continue Button
      And Check the total price calculated and the total products price
