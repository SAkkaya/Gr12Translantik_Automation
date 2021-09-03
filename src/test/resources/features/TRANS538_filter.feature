Feature: As a user, I should be able to filter "Tags"

  Scenario Outline: Columns should provide at least below methods
    Given the user is on the login page
    And the user enters the "<user>" and "UserUser123"
    When the user navigates to "Fleet" "Vehicles"
    Then the user should be able to filtering "Tags"
    And "Tags" column should provide following methods

      | Is Any Of     |
      | Is Not Any Of |

    Examples:
      | user            |
      | user10          |
      | storemanager80  |
      | salesmanager110 |

  @halil
  Scenario Outline:  After filtering each method, table should displays corresponding data related to selected method
    Given the user is on the login page
    And the user enters the "<user>" and "UserUser123"
    When the user navigates to "Fleet" "Vehicles"
    Then the user should be able to filtering "Tags"
    And after "<each>" method filtering and after choose "<value>" user should see the filtered data on the table

    Examples:
      | user            | each          | value   |
      | user10          | Is Any Of     | Compact |
      | storemanager80  | Is Not Any Of | Junior  |
      | salesmanager110 | Is Any Of     | Senior  |
      | user20          | Is Not Any Of | Sedan   |