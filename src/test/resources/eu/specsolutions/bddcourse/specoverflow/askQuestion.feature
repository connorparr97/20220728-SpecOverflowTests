Feature: Ask Question Testing

  Rule: User must be logged in to post question
  Scenario: User not logged in
    When user submits question not logged in
    Then page prompts user with message not logged in

  Rule: User must enter something into the title and body section
  Scenario: User submits question without entering anything into title and body section
    When user submits question without anything in title and body
    Then page prompts user with message title and body cannot be empty

  Scenario: User submits a question with input to the body and title
    When user submits question with characters in body and title
    Then user question should be posted to website







