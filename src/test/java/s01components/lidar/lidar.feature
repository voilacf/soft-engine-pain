Feature: lidar

  Scenario: Test component
    Given My autonomous vehicle contains a lidar
    Then The lidar component should not be null

  Scenario: Test on event
    Given I have a lidar component and its control unit
    When The lidar control unit receives an on event
    Then The lidar turned on

  Scenario: Test off event
    Given I have a lidar component and its control unit
    When The lidar control unit receives an off event
    Then The lidar turned off

