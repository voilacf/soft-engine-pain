Feature: observer
  Scenario: Test battery temperature change
    Given I have a battery cell
    When I discharge the battery
    Then The temperature should change
