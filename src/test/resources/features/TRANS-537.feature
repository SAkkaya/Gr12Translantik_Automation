@TRANS-537
Feature: As a user, I should be able to filter the "Driver" and "Location" columns

  Scenario Outline:  Columns should provide at least below methods
    Given The user is on the login page
    And the user logged in as "<userType>"
    When the user navigates to "Fleet" "Vehicles"
    And the user click manage filters and  select "Driver" checkbox
    And the user click "Driver" dropdown button
    Then the user can see at least following methods
      | contains         |
      | does not contain |
      | starts with      |
      | ends with        |
      | is any of        |
      | is not any of    |
      | is empty         |
      | is not empty     |

    Examples:
      | userType      |
      | driver        |
      | sales Manager |
      | store manager |

  Scenario Outline:  Columns should provide at least below methods
    Given The user is on the login page
    And the user logged in as "<userType>"
    When the user navigates to "Fleet" "Vehicles"
    And the user click manage filters and  select "Location" checkbox
    And the user click "Location" dropdown button
    Then the user can see at least following methods
      | contains         |
      | does not contain |
      | starts with      |
      | ends with        |
      | is any of        |
      | is not any of    |
      | is empty         |
      | is not empty     |

    Examples:
      | userType      |
      | driver        |
      | sales Manager |
      | store manager |


  Scenario Outline: After filtering each method, table should displays corresponding data related to selected method
    Given The user is on the Vehicles Pages
    And the user click manage filters and  select "Driver" checkbox
    When the user select filter <method>
    And write "John Doe" into input box
    And click on update button
    Then table should displays corresponding "data" related to selected method

    Examples:
      | method          |
      | contains         |
      | does not contain |
      | starts with      |
      | ends with        |
      | is Equal         |

  Scenario Outline: After filtering each method, table should displays corresponding data related to selected method
    Given The user is on the Vehicles Pages
    And the user click manage filters and  select "Location" checkbox
    When the user select filter <method>
    And write "Pittsburgh" into input box
    And click on update button
    Then table should displays corresponding "data" related to selected method

    Examples:
      | method          |
      | contains         |
      | does not contain |
      | starts with      |
      | ends with        |
      | is Equal         |