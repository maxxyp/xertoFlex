Feature: Search for Items

  Background:
    Given I am on the Homepage

  @Search
  Scenario: As a user I want to search for an item
    And I search for "shirt" in the search input box
    And I see search product listing page
    When I click on the first item on page
    Then I verify search description "Faded Short Sleeves T-shirt" on the product page
    And I also see option to slect sizes


  @Search
  Scenario: As a user I want to search for an item and check if its available in stock
    And I search for "shirt" in the search input box
    And I see search product listing page
    When I click on the first item on page
    Then I verify search description "Faded Short Sleeves T-shirt" on the product page
    And I also see option to slect sizes

  @Search
  Scenario: As a user I want to search for an item and check if its out of stock
    And I search for "shirt" in the search input box
    And I see search product listing page
    When I click on the first item on page
    Then I verify search description "Faded Short Sleeves T-shirt" on the product page
    And I also see option to slect sizes