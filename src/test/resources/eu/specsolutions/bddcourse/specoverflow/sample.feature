Feature: Sample

Rule: The browser must load the login page when the login button is clicked

  Scenario: Login button clicked
    When user clicks the login button
    Then browser loads login page

Rule: The browser must load the register page when the register button is clicked

  Scenario: Register button clicked
    When user clicks the register button
    Then browser loads register page

