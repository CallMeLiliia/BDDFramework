@departure/destination @homepage @smoke
Feature: Booking Flight

  Background: 
    Given I am on the home page

  Scenario Outline: As a user I should be able to book a flight
    When I click on search button
    Then I shoukd be able to enter "<departure>"
    Then I click on To button
    And I should be able to enter "<destination>"

    Examples: 
      | departure  | destination |
      | Washington | Paris       |
      | Miami      | Dublin      |
      | Istambul   | Madrid      |
      | London     | Washington  |
#When I click on reverse arrow
#Then I should verify that Origin and Destination are been reversed
