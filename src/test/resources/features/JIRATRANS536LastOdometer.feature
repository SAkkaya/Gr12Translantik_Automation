@TRANS-605
Feature:

	#{color:#00875a}*User Story :* {color}
	#
	#As a user, I should be able to filter the "Last Odometer" column
	#
	#
	#
	#{color:#de350b}*_Acceptance Criteria:_*{color}
	#
	#1-Columns should provide at least below methods and:
	#
	#                *{color:#FF0000}->{color}* *{color:#FF0000}between{color}*
	#                -> not between
	#
	#                -> equals
	#
	#                ->not equals
	#                -> more than
	#                -> less than
	#
	#                -> is empty
	#
	#                -> is not empty
	# 2- After filtering each method, table should displays corresponding data related to selected method
  @TRANS-604
  Scenario Outline: Last Odometer Between Filtering
    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user navigates2 to "Fleet", "Vehicles"
    Then the user select the "Last Odometer" "between" filtering type
    And the user enters the informations <first> and <last>
    And the user should see the correct results from "Last Odometer" "between" <first> <last>

    Examples:
      | userType      | first | last |
      | driver        | 4     | 50   |
      | driver        | 50    | 100  |
      | driver        | 4     | 100  |
      | store manager | 4     | 50   |
      | store manager | 50    | 100  |
      | store manager | 4     | 100  |
      | sales manager | 4     | 50   |
      | sales manager | 50    | 100  |
      | sales manager | 4     | 100  |


	#{color:#00875a}*User Story :* {color}
	#
	#As a user, I should be able to filter the "Last Odometer" column
	#
	#
	#
	#{color:#de350b}*_Acceptance Criteria:_*{color}
	#
	#1-Columns should provide at least below methods and:
	#
	# {color:#172b4d}                -> between{color}
	#                 {color:#de350b}*-> not between*{color}
	#
	#                -> {color:#172b4d}equals{color}
	#
	#                ->not equals
	#                 -> more than
	#                 -> less than
	#
	#                -> is empty
	#
	#                -> is not empty
	#  2- After filtering each method, table should displays corresponding data related to selected method
  @TRANS-606
  Scenario Outline: Last Odometer Not Between Filtering
    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user navigates2 to "Fleet", "Vehicles"
    Then the user select the "Last Odometer" "between" filtering type
    And the user enters the informations <first> and <last>
    And the user should see the correct results from "Last Odometer" "between" <first> <last>

    Examples:
      | userType      | first | last |
      | driver        | 4     | 50   |
      | driver        | 50    | 100  |
      | driver        | 4     | 100  |
      | store manager | 4     | 50   |
      | store manager | 50    | 100  |
      | store manager | 4     | 100  |
      | sales manager | 4     | 50   |
      | sales manager | 50    | 100  |
      | sales manager | 4     | 100  |


	#{color:#00875a}*User Story :* {color}
	#
	#As a user, I should be able to filter the "Last Odometer" column
	#
	#
	#
	#{color:#de350b}*_Acceptance Criteria:_*{color}
	#
	#1-Columns should provide at least below methods and:
	#
	# {color:#172b4d}                -> between{color}
	#                 {color:#172b4d}{color:#de350b}{color:#172b4d}->{color} {color}{color}not between
	#
	#                *{color:#de350b}-> equals{color}*
	#
	#                ->not equals
	#                 -> more than
	#                 -> less than
	#
	#                -> is empty
	#
	#                -> is not empty
	#  2- After filtering each method, table should displays corresponding data related to selected method
  @TRANS-607
  Scenario Outline: Last Odometer Equals Filtering
    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user navigates2 to "Fleet", "Vehicles"
    Then the user select the "Last Odometer" "between" filtering type
    And the user enters the informations <first> and <last>
    And the user should see the correct results from "Last Odometer" "between" <first> <last>

    Examples:
      | userType      | first | last |
      | driver        | 4     | 50   |
      | driver        | 50    | 100  |
      | driver        | 4     | 100  |
      | store manager | 4     | 50   |
      | store manager | 50    | 100  |
      | store manager | 4     | 100  |
      | sales manager | 4     | 50   |
      | sales manager | 50    | 100  |
      | sales manager | 4     | 100  |


	#{color:#00875a}*User Story :* {color}
	#
	#As a user, I should be able to filter the "Last Odometer" column
	#
	#
	#
	#{color:#de350b}*_Acceptance Criteria:_*{color}
	#
	#1-Columns should provide at least below methods and:
	#
	# {color:#172b4d}                -> between{color}
	#                 {color:#172b4d}->{color} not between
	#
	#                {color:#de350b}{color:#172b4d}-> equals{color}{color}
	#
	#                {color:#de350b}*->not equals*{color}
	#                 -> more than
	#                 -> less than
	#
	#                -> is empty
	#
	#                -> is not empty
	#  2- After filtering each method, table should displays corresponding data related to selected method
  @TRANS-608
  Scenario Outline: Last Odometer Not Equals Filtering
    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user navigates2 to "Fleet", "Vehicles"
    Then the user select the "Last Odometer" "between" filtering type
    And the user enters the informations <first> and <last>
    And the user should see the correct results from "Last Odometer" "between" <first> <last>

    Examples:
      | userType      | first | last |
      | driver        | 4     | 50   |
      | driver        | 50    | 100  |
      | driver        | 4     | 100  |
      | store manager | 4     | 50   |
      | store manager | 50    | 100  |
      | store manager | 4     | 100  |
      | sales manager | 4     | 50   |
      | sales manager | 50    | 100  |
      | sales manager | 4     | 100  |


	#{color:#00875a}*User Story :* {color}
	#
	#As a user, I should be able to filter the "Last Odometer" column
	#
	#
	#
	#{color:#de350b}*_Acceptance Criteria:_*{color}
	#
	#1-Columns should provide at least below methods and:
	#
	# {color:#172b4d}                -> between{color}
	#                 {color:#172b4d}->{color} not between
	#
	#                {color:#172b4d}{color:#de350b}{color:#172b4d}->{color} {color:#172b4d}equals{color}{color}{color}
	#
	#                 ->not equals
	#                 *{color:#de350b}-> more than{color}*
	#                 -> less than
	#
	#                -> is empty
	#
	#                -> is not empty
	#  2- After filtering each method, table should displays corresponding data related to selected method
  @TRANS-609
  Scenario Outline: Last Odometer More Than Filtering
    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user navigates2 to "Fleet", "Vehicles"
    Then the user select the "Last Odometer" "between" filtering type
    And the user enters the informations <first> and <last>
    And the user should see the correct results from "Last Odometer" "between" <first> <last>

    Examples:
      | userType      | first | last |
      | driver        | 4     | 50   |
      | driver        | 50    | 100  |
      | driver        | 4     | 100  |
      | store manager | 4     | 50   |
      | store manager | 50    | 100  |
      | store manager | 4     | 100  |
      | sales manager | 4     | 50   |
      | sales manager | 50    | 100  |
      | sales manager | 4     | 100  |


	#{color:#00875a}*User Story :* {color}
	#
	#As a user, I should be able to filter the "Last Odometer" column
	#
	#
	#
	#{color:#de350b}*_Acceptance Criteria:_*{color}
	#
	#1-Columns should provide at least below methods and:
	#
	# {color:#172b4d}                -> between{color}
	#                 {color:#172b4d}->{color} not between
	#
	#                {color:#172b4d}->{color} {color:#172b4d}equals{color}
	#
	#                ->not equals
	#                 {color:#172b4d}-> more than{color}
	#                 *{color:#de350b}-> less than{color}*
	#
	#                -> is empty
	#
	#                -> is not empty
	#  2- After filtering each method, table should displays corresponding data related to selected method
  @TRANS-610
  Scenario Outline: Last Odometer Less Than Filtering
    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user navigates2 to "Fleet", "Vehicles"
    Then the user select the "Last Odometer" "between" filtering type
    And the user enters the informations <first> and <last>
    And the user should see the correct results from "Last Odometer" "between" <first> <last>

    Examples:
      | userType      | first | last |
      | driver        | 4     | 50   |
      | driver        | 50    | 100  |
      | driver        | 4     | 100  |
      | store manager | 4     | 50   |
      | store manager | 50    | 100  |
      | store manager | 4     | 100  |
      | sales manager | 4     | 50   |
      | sales manager | 50    | 100  |
      | sales manager | 4     | 100  |


	#{color:#00875a}*User Story :* {color}
	#
	#As a user, I should be able to filter the "Last Odometer" column
	#
	#
	#
	#{color:#de350b}*_Acceptance Criteria:_*{color}
	#
	#1-Columns should provide at least below methods and:
	#
	# {color:#172b4d}                -> between{color}
	#                 {color:#172b4d}->{color} not between
	#
	#                {color:#172b4d}->{color} {color:#172b4d}equals{color}
	#
	#                ->not equals
	#                 {color:#172b4d}-> more than{color}
	#                 {color:#172b4d}-> less than{color}
	#
	#{color:#172b4d}                {color:#de350b}*->Equals or More Than*{color}{color}
	#
	#{color:#172b4d}                -> Equals or Less Than{color}
	#
	#               {color:#172b4d} -> is empty{color}
	#
	#                -> is not empty
	#  2- After filtering each method, table should displays corresponding data related to selected method
  @TRANS-611
  Scenario Outline: Last Odometer Equals or More Than Filtering
    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user navigates2 to "Fleet", "Vehicles"
    Then the user select the "Last Odometer" "between" filtering type
    And the user enters the informations <first> and <last>
    And the user should see the correct results from "Last Odometer" "between" <first> <last>

    Examples:
      | userType      | first | last |
      | driver        | 4     | 50   |
      | driver        | 50    | 100  |
      | driver        | 4     | 100  |
      | store manager | 4     | 50   |
      | store manager | 50    | 100  |
      | store manager | 4     | 100  |
      | sales manager | 4     | 50   |
      | sales manager | 50    | 100  |
      | sales manager | 4     | 100  |


	#{color:#00875a}*User Story :* {color}
	#
	#As a user, I should be able to filter the "Last Odometer" column
	#
	#
	#
	#{color:#de350b}*_Acceptance Criteria:_*{color}
	#
	#1-Columns should provide at least below methods and:
	#
	# {color:#172b4d}                -> between{color}
	#                 {color:#172b4d}->{color} not between
	#
	#                {color:#172b4d}->{color} {color:#172b4d}equals{color}
	#
	#                ->not equals
	#                 {color:#172b4d}-> more than{color}
	#                 {color:#172b4d}-> less than{color}
	#
	#{color:#172b4d}                ->Equals or More Than{color}
	#
	#                 {color:#de350b}*-> Equals or Less Than*{color}
	#
	#               {color:#172b4d} -> is empty{color}
	#
	#                -> is not empty
	#  2- After filtering each method, table should displays corresponding data related to selected method
  @TRANS-612
  Scenario Outline: Last Odometer Equals or Less Than Filtering
    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user navigates2 to "Fleet", "Vehicles"
    Then the user select the "Last Odometer" "between" filtering type
    And the user enters the informations <first> and <last>
    And the user should see the correct results from "Last Odometer" "between" <first> <last>

    Examples:
      | userType      | first | last |
      | driver        | 4     | 50   |
      | driver        | 50    | 100  |
      | driver        | 4     | 100  |
      | store manager | 4     | 50   |
      | store manager | 50    | 100  |
      | store manager | 4     | 100  |
      | sales manager | 4     | 50   |
      | sales manager | 50    | 100  |
      | sales manager | 4     | 100  |


	#{color:#00875a}*User Story :* {color}
	#
	#As a user, I should be able to filter the "Last Odometer" column
	#
	#
	#
	#{color:#de350b}*_Acceptance Criteria:_*{color}
	#
	#1-Columns should provide at least below methods and:
	#
	# {color:#172b4d}                -> between{color}
	#                 {color:#172b4d}->{color} not between
	#
	#                {color:#172b4d}->{color} {color:#172b4d}equals{color}
	#
	#                ->not equals
	#                 {color:#172b4d}-> more than{color}
	#                 {color:#172b4d}-> less than{color}
	#
	#{color:#172b4d}                ->Equals or More Than{color}
	#
	#                {color:#172b4d}-> Equals or Less Than{color}
	#
	#               {color:#de350b} *-> is empty*{color}
	#
	#                -> is not empty
	#  2- After filtering each method, table should displays corresponding data related to selected method
  @TRANS-613
  Scenario Outline: Last Odometer Is Empty Filtering
    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user navigates2 to "Fleet", "Vehicles"
    Then the user select the "Last Odometer" "between" filtering type
    And the user enters the informations <first> and <last>
    And the user should see the correct results from "Last Odometer" "between" <first> <last>

    Examples:
      | userType      | first | last |
      | driver        | 4     | 50   |
      | driver        | 50    | 100  |
      | driver        | 4     | 100  |
      | store manager | 4     | 50   |
      | store manager | 50    | 100  |
      | store manager | 4     | 100  |
      | sales manager | 4     | 50   |
      | sales manager | 50    | 100  |
      | sales manager | 4     | 100  |


	#{color:#00875a}*User Story :* {color}
	#
	#As a user, I should be able to filter the "Last Odometer" column
	#
	#
	#
	#{color:#de350b}*_Acceptance Criteria:_*{color}
	#
	#1-Columns should provide at least below methods and:
	#
	# {color:#172b4d}                -> between{color}
	#                 {color:#172b4d}->{color} not between
	#
	#                {color:#172b4d}->{color} {color:#172b4d}equals{color}
	#
	#                ->not equals
	#                 {color:#172b4d}-> more than{color}
	#                 {color:#172b4d}-> less than{color}
	#
	#{color:#172b4d}                ->Equals or More Than{color}
	#
	#                {color:#172b4d}-> Equals or Less Than{color}
	#
	#               {color:#172b4d} -> is empty{color}
	#
	#                {color:#de350b}*-> is not empty*{color}
	#  2- After filtering each method, table should displays corresponding data related to selected method
  @TRANS-614
  Scenario Outline: Last Odometer Is Not Empty Filtering
    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user navigates2 to "Fleet", "Vehicles"
    Then the user select the "Last Odometer" "between" filtering type
    And the user enters the informations <first> and <last>
    And the user should see the correct results from "Last Odometer" "between" <first> <last>

    Examples:
      | userType      | first | last |
      | driver        | 4     | 50   |
      | driver        | 50    | 100  |
      | driver        | 4     | 100  |
      | store manager | 4     | 50   |
      | store manager | 50    | 100  |
      | store manager | 4     | 100  |
      | sales manager | 4     | 50   |
      | sales manager | 50    | 100  |
      | sales manager | 4     | 100  |
