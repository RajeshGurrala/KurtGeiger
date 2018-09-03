@KG
Feature: Search And Assert A Brand and add an item to the cart
  Scenario: search for a brand and assert results
    Given I am on the homepage
    When I select brand category from the header
    Then I should see the list of brands
    And I select "DOLCE & GABBANA" brand from the list
    Then I should see the list of products from "DOLCE & GABBANA"

    Scenario: add an item to the cart, check out and assert
    Given I select men category from the header
    And I am on PDP
    When I select any colour and size for the chosen men category
    And I add the product to the bag
    Then I can see the bag with single item
    And I click 'Proceed to Checkout'
    Then I should be on checkout page


