#Author: Asif

Feature: Feature to test login
  Scenario: Successful login with valid credential
    Given browser is open
    Then go to the login page
    Then welcome popup came, close the popup
    When user enters "aa.asifabu@gmail.com" and "123456asif"
    And click on login button
    Then user is navigated to the home page
