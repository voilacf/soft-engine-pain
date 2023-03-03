Feature: components

  Scenario: Test components
    Given I have a autonomous vehicle made of several components
    Then The components should not be null

  Scenario: Test brake control unit
    Given I have a brake control unit in my vehicle
    When The control unit receives a BrakeSetEvent
    Then The brake percentage has changed

  Scenario: Test brake light control unit
    Given I have a brake light control unit
    When I use it to turn the brake light off
    Then The brake light is off
    When I use it to turn the brake light on
    Then The brake light is on

