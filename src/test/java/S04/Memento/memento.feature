Feature: memento

  Scenario: Test default settings
    Given I have a configuration memento
    Then The memento should have the default settings

  Scenario: Test vehicle configuration
    Given I have a vehicle configuration
    When I load the settings from the json file
    When I restore the settings from the memento
    Then The memento should have the settings from the json file
    When I print the settings it should not throw an exception
    When I change the settings
    Then The settings should be changed
    When I restore the settings from the memento
    Then The memento should have the settings from the json file
    When I change the settings
    When I save the settings
    Then The memento should have the settings from the json file
    When I restore the settings from the memento
    Then The memento should have the settings from the json file
