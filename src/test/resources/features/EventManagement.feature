@RegressionAndroid
Feature: Events Management
  In order to calculate how much beer to buy
  As a user
  I want to be able to confirm my attendance to a new event

  Scenario: Log at a new event
    Given the user is logged into the application
    When the user try to confirm his attendance to 'Halloween' event
    Then the user will be get a confirmation about it


  Scenario: Undo the log at a new event
    Given the user has already confirm his attendace
    When the user try undo his attendance
    Then the user will be get a confirmation about it
