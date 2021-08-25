Feature: Last Odometer

  Scenario Outline: Last Odometer between filters

    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user navigates to "Fleet", "Vehicles"
    Then the user select the "Last Odometer", "between" filtering type
    And the user enters information <first>, <last>
    And the user should see the correct result from "Last Odometer" <first>, <last>


    Examples:
      | userType | first | last |
      | driver   | 4     | 50   |
      | driver   | 50    | 100  |
      | driver   | 4     | 100  |

    Examples:
      | userType      | first | last |
      | store manager | 4     | 50   |
      | store manager | 50    | 100  |
      | store manager | 4     | 100  |

    Examples:
      | userType      | first | last |
      | sales manager | 4     | 50   |
      | sales manager | 50    | 100  |
      | sales manager | 4     | 100  |


