Feature: As a boss, I want to register an employee

  @DummyEmployee
  Scenario: User create employee and get return employee data
    Given user prepare dummy rest
    When user post new employee data
    Then response post should be true
    When user retrieve employee data
    Then response get should be true