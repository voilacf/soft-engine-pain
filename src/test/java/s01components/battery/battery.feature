Feature: battery

  Scenario: Test battery component
    Given My autonomous vehicle contains a battery
    Then The battery component should not be null
