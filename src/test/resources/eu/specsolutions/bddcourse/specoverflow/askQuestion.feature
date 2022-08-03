Feature: Ask Question Testing

  Rule: User must be logged in to post question
  Scenario: User not logged in
    When user submits question not logged in
    Then page prompts user with message not logged in

  Rule: User must enter something into the title and body section
  Scenario: User submits question without entering anything into
    title and body section
    When user submits question without anything in title or body
    Then page prompts user with message title and body cannot be empty




