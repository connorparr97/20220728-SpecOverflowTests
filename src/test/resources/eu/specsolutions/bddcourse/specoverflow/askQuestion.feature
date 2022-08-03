Feature: Ask Question Testing

  Rule: User must be logged in to post question
  Scenario: User not logged in
    When user submits question not logged in
    Then page prompts user with message not logged in


