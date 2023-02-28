Feature: state

  Scenario: Test the door
    Given I have a door class
    Then The door should be closed
    When I toggle the door state
    Then The door should be open
    When I toggle the door state
    Then The door should be closed