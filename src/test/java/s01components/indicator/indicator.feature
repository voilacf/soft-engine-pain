Feature: indicator

  Scenario: Test component
    Given My autonomous vehicle contains two indicators
    Then The indicator components should not be null

  Scenario: Test left indicator on
    Given I have an indicator component and its control unit
    When The indicator control unit receives an left indicator on event
    Then The left indicator is turned on

  Scenario: Test left indicator off
    Given I have an indicator component and its control unit
    When The indicator control unit receives an left indicator off event
    Then The left indicator is turned off

  Scenario: Test right indicator on
    Given I have an indicator component and its control unit
    When The indicator control unit receives an right indicator on event
    Then The right indicator is turned on

  Scenario: Test right indicator off
    Given I have an indicator component and its control unit
    When The indicator control unit receives an right indicator off event
    Then The right indicator is turned off

  Scenario: Test hazard on event
    Given I have an indicator component and its control unit
    When The indicator control unit receives an hazard on event
    Then The indicator hazard is turned on

  Scenario: Test hazard off event
    Given I have an indicator component and its control unit
    When The indicator control unit receives an hazard off event
    Then The indicator hazard is turned off
