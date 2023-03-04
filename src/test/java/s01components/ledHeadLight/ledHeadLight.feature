Feature: ledHeadLight

  Scenario: Test led head light component
    Given My autonomous vehicle contains a led component
    Then The led component should not be null

  Scenario: Test on event
    Given I have a led component and its control unit
    When The led control unit receives an on event
    Then The led turned on

  Scenario: Test off event
    Given I have a led component and its control unit
    When The led control unit receives an off event
    Then The led turned off

  Scenario: Test high beam event
    Given I have a led component and its control unit
    When The led control unit receives a high beam event
    Then The led activated its high beam

  Scenario: Test dimm event
    Given I have a led component and its control unit
    When The led control unit receives a dimm event
    Then The led light is dimmed
