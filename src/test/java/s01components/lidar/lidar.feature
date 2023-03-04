Feature: lidar

  Scenario: Test lidar component
    Given My autonomous vehicle contains a lidar
    Then The lidar component should not be null

  Scenario: Test lidar on event
    Given My autonomous vehicle contains a lidar
    Then The lidar turns on when using on-method

  Scenario: Test lidar off Event
    Given My autonomous vehicle contains a lidar
    Then The lidar turns off when using off-method

