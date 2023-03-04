Feature: brakeLight

  Scenario: Test brake light component
    Given My autonomous vehicle contains a brake light
    Then The brake light component should not be null

  Scenario: Test on Event
    Given I have a brake light component and its control unit
    When The brake light control unit receives an on Event
    Then The brake light turned on

  Scenario: Test off Event
    Given I have a brake light component and its control unit
    When The brake light control unit receives an off Event
    Then The brake light turned off
