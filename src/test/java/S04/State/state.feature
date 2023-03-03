Feature: state

  Scenario: Test the door
    Given I have a door class
    Then The door should be "closed"
    When I toggle the door state door currently "closed"
    Then The door should be "opened"
    When I toggle the door state door currently "opened"
    Then The door should be "closed"