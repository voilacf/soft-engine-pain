Feature: electricEngine

  Scenario: Test electric engine component
    Given My autonomous vehicle contains an electric engine
    Then The electric engine component should not be null

  Scenario: Test engine on event
    Given My autonomous vehicle contains an electric engine
    Then The engine turns on when using on-method

  Scenario: Test engine off Event
    Given My autonomous vehicle contains an electric engine
    Then The engine turns off when using off-method

  Scenario: Test engine increase RPM Event
    Given I have an electric engine component and its control unit
    When The electric engine control unit receives an increase rpm event
    Then The electric engine rpm has increased

  Scenario: Test engine decrease RPM Event
    Given I have an electric engine component and its control unit
    When The electric engine control unit receives a decrease rpm event
    Then The electric engine rpm has decreased

