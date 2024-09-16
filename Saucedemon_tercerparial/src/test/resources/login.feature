Feature: Login Sauce Demo App

  Background:

    Given I am in sauce demo web page

    Scenario Outline: Login into Sauce Demo with valid credentials
      Given I set the user name text box with "<user>"
      And I set the password text box with "<password>"
      When I click on the login button
      Examples:
        | user          | password     |
        | problem_user  | secret_sauce |
        | standard_user | secret_sauce |
