Feature:


  Scenario Outline: Columns should provide methods
    Given the user is on the login page
    And the user enters the "<user>" and "UserUser123"
    When the user navigates to "Fleet", "Vehicles"
    Then the user should be able to filtering "Immatriculation Date"
    And the user should be able to another filtering "First Contract Date"
    Then the "Immatriculation Date" should provide following methods
      | between      |
      | not between  |
      | later than   |
      | earlier than |
      | equals       |
      | not equals   |

    Then the "First Contract Date" should provide following methods
      | between      |
      | not between  |
      | later than   |
      | earlier than |
      | equals       |
      | not equals   |

    Examples:
      | user            |
      | user12          |
      | storemanager70  |
      | salesmanager110 |


  Scenario Outline: After Filtering Immatriculation Date Verify Execution Of Methods
    Given the user is on the login page
    And the user enters the "<user>" and "UserUser123"
    When the user navigates to "Fleet", "Vehicles"
    Then the user should be able to filtering "Immatriculation Date"
    And after the filter "Immatriculation Date" "<each>" method user should see the filtered data on the table

    Examples:
      | user            | each         |
      | user10          | between      |
      | storemanager85  | not between  |
      | salesmanager110 | later than   |
      | user20          | earlier than |
      | storemanager70  | equals       |
      | salesmanager130 | not equals   |


  Scenario Outline: After Filtering Immatriculation Date Verify Execution Of Methods
    Given the user is on the login page
    And the user enters the "<user>" and "UserUser123"
    When the user navigates to "Fleet", "Vehicles"
    Then the user should be able to filtering "First Contract Date"
    And after the filter "First Contract Date" "<each>" method user should see the filtered data on the table

    Examples:
      | user            | each         |
      | user10          | between      |
      | storemanager85  | not between  |
      | salesmanager110 | later than   |
      | user20          | earlier than |
      | storemanager70  | equals       |
      | salesmanager130 | not equals   |