@RegressionAndroid
Feature: Events Management
  In order to calculate how much beer to buy
  As a user
  I want to be able to confirm my attendance to a new event

  Scenario: Log at a new event
    Given the user has not confirmed his attendance to the event 'Halloweeen 2017'
    When the user try to confirm his attendance
    Then the user will be get a confirmation message 'Registered' about it


  Scenario: Undo the log at a new event
    Given the user has already confirm his attendance to the event 'Halloweeen 2017'
    When the user try undo his attendance
    Then the user will be get a confirmation message 'Register' about it
