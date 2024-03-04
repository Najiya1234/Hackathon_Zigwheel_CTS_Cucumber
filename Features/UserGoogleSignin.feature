Feature: Google Sign-in Functionality

  Scenario: Sign in with Google
    Given User navigates to the forum
    Then User verify Forum Page Title
    When User clicks on the login/sign-up button
    And User clicks on the Google
    And User enters invalid email address
    And User clicks on Next button
    Then User should see an error message about invalid email
