@calendar @homepage @smoke @regression
Feature: Picking departure and Return date for round trip

  Background: 
    Given I am on the home page
    And Trip type should be displayed as a "Round Trip"
    When I click on depart-return button
@wip
  Scenario: As a user I should be able to pick depart and return dates
    Then I click on depart "depart" date and month "month", year "year"
    And I click on return "return" date and month "month",year "year"
    And Click on done button
    Then Picked date should be displayed in depart-return button
@wip
  Scenario: Verify next and previous month buttons
    Then I click 4 times on  select next month button
    And Calendar should display  correct month



