Feature: camera

  Scenario: Test camera component
    Given My autonomous vehicle contains a camera
    Then The camera component should not be null

  Scenario: Test on Event
    Given I have a camera component and its control unit
    When The camera control unit receives an on event
    Then The camera turned on

  Scenario: Test off Event
    Given I have a camera component and its control unit
    When The camera control unit receives an off event
    Then The camera turned off

