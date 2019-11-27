Feature: Login

  @SignIn
  Scenario Outline: As a user I want to login successfully
    Given I am on the Homepage
    And I click on sign in
    And I enter my email "<email>" address
    And I enter my password "<password>"
    When I click on te sign in button
    Then I verify that my "<actual_name>" is displayed
    And I sign out

    Examples:
      |email                            | password   |actual_name  |
      |automationsoftskills@gmail.com   |today01     |David Mike    |
      |mike261@gmail.com                |today01     |Mary Sara     |
      |esther@yahoo.com                 |monday01    |Esther agnes  |



