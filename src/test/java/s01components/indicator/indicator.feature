Feature: indicator

  Scenario: Test component
    Given My autonomous vehicle contains an indicator
    Then The indicator components should not be null

  Scenario: Test left indicator on event
    Given I have an indicator component and its control unit
    When The control unit receives an Left-Indicator On Event
    Then The left indicator turns on

  Scenario: Test left indicator off Event
    Given I have an indicator component and its control unit
    When The control unit receives an Left-Indicator Off Event
    Then The left indicator turns off

  Scenario: Test right indicator on event
    Given I have an indicator component and its control unit
    When The control unit receives an Right-Indicator On Event
    Then The right indicator turns on

  Scenario: Test right indicator off Event
    Given I have an indicator component and its control unit
    When The control unit receives an Right-Indicator Off Event
    Then The right indicator turns off

  Scenario: Test hazard on event
    Given I have an indicator component and its control unit
    When The control unit receives an Hazard On Event
    Then The hazard turns on

  Scenario: Test hazard off Event
    Given I have an indicator component and its control unit
    When The control unit receives an Hazard Off Event
    Then The hazard turns off
