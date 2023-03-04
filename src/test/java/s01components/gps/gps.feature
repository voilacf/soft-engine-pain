Feature: gps

  Scenario: Test gps component
    Given My autonomous vehicle contains a gps
    Then The gps component should not be null

  Scenario: Test on event
    Given I have a gps component and its control unit
    When The gps control unit receives an on event
    Then The gps turned on

  Scenario: Test off event
    Given I have a gps component and its control unit
    When The gps control unit receives an off event
    Then The gps turned off

  Scenario: Test connect with satellite event
    Given I have a gps component and its control unit
    When The control unit receives a connect with satellite event
    Then The gps connected with a satellite

