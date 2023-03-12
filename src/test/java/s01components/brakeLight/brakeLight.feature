Feature: brakeLight

  Scenario: Test brake light component
    Given My autonomous vehicle contains a brake light
    Then The brake light component should not be null

  Scenario: Test brake light on event
    Given My autonomous vehicle contains a brake light
    Then The brake light turns on when using on-method

  Scenario: Test brake light off Event
    Given My autonomous vehicle contains a brake light
    Then The brake light turns off when using off-method
