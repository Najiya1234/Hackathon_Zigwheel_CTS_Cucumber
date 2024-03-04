Feature: View Used Cars in Chennai

  Scenario: View Popular Models of Used Cars in Chennai
    Given User checking visibility of used cars dropdown
    When User move to the Used Cars Dropdown
    And User select Chennai from the dropdown
    Then User should extract the list of popular models and display the models
