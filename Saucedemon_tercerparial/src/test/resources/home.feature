Feature: Home feature

  Background: User login into Sauce Demo
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button


    Scenario Outline: Check the reset state option
      Then I order some products "<products>"
      And select the slide bar
      And reset the state app
      And Check if the state is now reseted
      Examples:
        | products                |
        | Sauce Labs Backpack     |
        | Sauce Labs Bike Light   |
        | Sauce Labs Bolt T-Shirt |

    Scenario: Check if the product is sorted by price
      And I click on the sortedComboBox option
