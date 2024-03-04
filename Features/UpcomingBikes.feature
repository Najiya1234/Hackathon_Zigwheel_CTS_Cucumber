Feature: Display upcoming Honda bikes with price less than 4 Lac with their name and  expected launch date in India

  Scenario: View upcoming Honda bikes with price less than 4 Lac
    Given User is on the homepage
    Then User verifying home page title
    When User move to  New Bikes dropdown
    And User selects Upcoming Bikes
    Then Verifing Upcoming Bike Page url
    When User selects Honda from the manufacturers dropdown
    Then verify Honda title
    When User clicks on View More Bikes
    Then User filter the bikes by price less than four lac and also displaying their name and expected launch date in India
