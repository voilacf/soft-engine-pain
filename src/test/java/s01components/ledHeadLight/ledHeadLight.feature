Feature: ledHeadLight

  Scenario: Test led head light component
    Given My autonomous vehicle contains a led component
    Then The led component should not be null

  Scenario: Test led on event
    Given My autonomous vehicle contains a led component
    Then The led turns on when using on-method

  Scenario: Test led off Event
    Given My autonomous vehicle contains a led component
    Then The led turns off when using off-method

  Scenario: Test led high beam event
    Given My autonomous vehicle contains a led component
    Then The led activated its high beam when using beam-method

  Scenario: Test led dimm event
    Given My autonomous vehicle contains a led component
    Then The led is dimmed when using dimm-method
