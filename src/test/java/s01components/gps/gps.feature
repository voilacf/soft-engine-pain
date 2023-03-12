Feature: gps

  Scenario: Test gps component
    Given My autonomous vehicle contains a gps
    Then The gps component should not be null

  Scenario: Test on event
    Given My autonomous vehicle contains a gps
    Then The gps turns on when using on-method

  Scenario: Test off Event
    Given My autonomous vehicle contains a gps
    Then The gps turns off when using off-method

  Scenario: Test connect with satellite event
    Given I have a gps component and its control unit
    When The control unit receives a connect with satellite event
    Then The gps connected with a satellite

