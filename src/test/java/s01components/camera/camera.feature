Feature: camera

  Scenario: Test camera component
    Given My autonomous vehicle contains a camera
    Then The camera component should not be null

  Scenario: Test camera on event
    Given My autonomous vehicle contains a camera
    Then The camera turns on when using on-method

  Scenario: Test camera off Event
    Given My autonomous vehicle contains a camera
    Then The camera turns off when using off-method
