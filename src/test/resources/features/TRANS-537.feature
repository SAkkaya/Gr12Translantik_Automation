@TRANS-537
Feature: As a user, I should be able to filter the "Driver" and "Location" columns

  Scenario Outline:  Columns should provide at least below methods
    Given The user is on the login page
    And the user logged in as "<userType>"
    When the user navigates to "Fleet" "Vehicles"
    And the user click manage "filters" and "driver" checkbox
    And the user click "driver" dropdown button
    Then the user can see at least below "<methods>"
    Examples:
      | methods          |
      | contains         |
      | does not contain |
      | starts with      |
      | ends with        |
      | is Equal         |

  Scenario Outline: After filtering each method, table should displays corresponding data related to selected method
    Given The user is on the Vehicles Pages
    When "<userType>" filters with at least below "<methods>"
    Then table should displays corresponding "data" related to selected "<methods>"

    Examples:
      | methods          |
      | contains         |
      | does not contain |
      | starts with      |
      | ends with        |
      | is Equal         |