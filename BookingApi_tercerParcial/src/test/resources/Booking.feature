Feature: Booking feature
  Background The test is oon the get, getids and post endpoints

    Scenario: /bookinids Get all the bookings ids
      Given Request getids end point
      Then check the status code 200
      And chek the response size not 0

    @Run
    Scenario: Get booking by id
      Given Request by id 13
      Then check the status code 200
      And check the response is not null in some parameters

    Scenario: Check if there's a conotrol on the id
      Given Request by id <"abcd">
      Then check the status code 404
      And check the response size 0

    Scenario: check if Method Post works corectly
      Given Request create
        | Juan  | Garcia | 1234 | true | 2017-06-19 | 2021-10-03 | Breakfast |
      Then check the status code 200

      Scenario: check that empty booking atributs can't be send
        Given Request create with empty booking
        Then check the status code 422


