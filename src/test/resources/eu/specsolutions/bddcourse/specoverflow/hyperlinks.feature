Feature: Hyperlink Testing

Rule:  The browser must load the home page when the home button is clicked
  Scenario: Home button clicked
  When user clicks the home button
  Then browser loads home page

Rule: The browser must load the login page when the login button is clicked

  Scenario: Login button clicked
    When user clicks the login button
    Then browser loads login page

Rule: The browser must load the register page when the register button is clicked

  Scenario: Register button clicked
    When user clicks the register button
    Then browser loads register page

Rule: The browser must load the questions page when the questions button is clicked

  Scenario: Questions button clicked
    When user clicks the questions button
    Then browser loads questions page

Rule: The browser must load the ask question page when the ask question button is clicked

  Scenario: Ask question button clicked
    When user clicks ask question button
    Then browser loads ask question page

Rule: The browser must log out user when logout button is pressed for a signed in user

  Scenario: Logout button pressed
    When user clicks logout button
    Then browser logs user out


