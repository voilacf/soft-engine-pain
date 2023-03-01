Feature: observer

  Scenario: Test battery sensor
    Given I have a battery cell
    Given I have a battery listener
    When I add the listener to the battery cell
    When I discharge the battery
    Then The listener should receive a temperature change

  Scenario: Test ultrasonic sensor
    Given I have an ultrasonic sensor
    Given I have a ultrasonic sensor listener
    When I add a listener to the sensor
    When The distance changes
    Then The listener should receive a distance change

  Scenario: Test door button sensor
    Given I have a door with a button sensor
    Given I have a door button sensor listener
    When I add a listener to the door button sensor
    When I press the door button sensor
    Then The listener should receive a button press
