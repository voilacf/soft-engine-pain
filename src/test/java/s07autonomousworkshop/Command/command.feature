Feature: command

  Scenario: Test Drive To Lifting Platform Command
    Given A vehicle and a lifting platform
    When Executing the drive to lifting platform command
    Then The vehicle is on the lifting platform
