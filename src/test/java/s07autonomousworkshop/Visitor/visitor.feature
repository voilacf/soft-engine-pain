Feature: visitor

  Scenario: Test roboter
    Given A vehicle and a roboter
    When roboter visits components
    Then components are functional