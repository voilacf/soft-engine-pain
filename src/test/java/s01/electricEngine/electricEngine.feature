Feature: electricEngine

  Scenario: Test electric engine component
    Given My autonomous vehicle contains an electric engine
    Then The electric engine component should not be null

  Scenario: Test on Event
    Given I have an electric engine component and its control unit
    When The electric engine control unit receives an on event
    Then The electric engine turned on

  Scenario: Test off Event
    Given I have an electric engine component and its control unit
    When The electric engine control unit receives an off event
    Then The electric engine turned off

  Scenario: Test increase RPM Event
    Given I have an electric engine component and its control unit
    When The electric engine control unit receives an increase rpm event
    Then The electric engine rpm has increased

  Scenario: Test decrease RPM Event
    Given I have an electric engine component and its control unit
    When The electric engine control unit receives a decrease rpm event
    Then The electric engine rpm has decreased

