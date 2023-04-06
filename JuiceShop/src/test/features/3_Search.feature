#Author: Asif

Feature: Search Feature

  Scenario: Verify Search Feature
    Given user is on home page
    Then verify search button
    Then search for apple
    Then verify the search result contains only apple product