#Author: Asif

Feature: Feature to Order

  Scenario: Add Item to the basket
    Given user is on home page
    Then add one item to the basket

  Scenario: Do checkout
    Given item is already available in the basket
    Then go to the checkout page
    Then click on the checkout button
    Then set a delivery address
    Then select the address and continue
#    Then choose delivery speed and continue
#    Then add new card
#    Then choose added card and continue
#    Then place order