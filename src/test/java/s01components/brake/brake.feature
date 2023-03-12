Feature: brake

  Scenario: Test brake component
    Given My autonomous vehicle contains a brake
    Then The brake component should not be null

  Scenario: Test setBrake Event
    Given I have a brake component and its control unit
    When The brake control unit receives a BrakeSetEvent
    Then The brake percentage has changed
