Feature: Register

  Background:
    Given I am on the Homepage
    And I click on sign in

  Scenario: As a registered user when I try to create an account with email already registered error message should be displayed
    And I enter email addres that is already in use
    When I click on the create account button
    Then I should see an error message

  Scenario: Register New User
    And I enter my new "mary" address
    And I click on the create account button
    And I click on the male radio button
    And I enter a firstname "Mary"
    And I enter a lastname "Williams"
    And I enter a password "Sunday01"
    And I enter date of birth
    When I click on register button
    Then I am registered successfully

