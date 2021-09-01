@TRANS-623
Feature: 

	#As a user, I should be able to filter table
	#
	# 
	#
	#{color:#de350b}*_Acceptance Criteria:_*{color}
	#
	#1- Manage filter should be hidden as default
	#
	#2- Manage filter options should be displayed once the user clicks on the filter button
	# *3- User can apply filtering for each of the data columns on the page*
	#
	#4-User can  remove all "filterings" by using the reset button
	# *5- All user types can perform filtering actions*
	# 6- Application supports multiple filtering of columns1
	@TRANS-559 @TRANS-603 @EU5GR12
	Scenario Outline: User can apply filtering for each of the data columns on the page
		  Given the "<usertype>" user is logged in
		    When the user navigates to "Fleet" "Vehicles" page
		    And the user click the filter button
		    And the user click on manage filter button
		    Then User can apply filtering for each of the "<dataColumns>"  on the page
		
		    Examples:
		      | usertype      | dataColumns         |
		      | driver        | Driver              |
		      | driver        | Tags                |	

	#As a user, I should be able to filter table
	#
	# 
	#
	#{color:#de350b}*_Acceptance Criteria:_*{color}
	#
	#1- Manage filter should be hidden as default
	#
	#2- Manage filter options should be displayed once the user clicks on the filter button
	# 3- User can apply filtering for each of the data columns on the page
	#
	#*4-User can  remove all "filterings" by using the reset button*
	# 5- All user types can perform filtering actions
	# 6- Application supports multiple filtering of columns
	@TRANS-560 @TRANS-603 @EU5GR12
	Scenario Outline: using reset button
		  Given the "<usertype>" user is logged in
		    When the user navigates to "Fleet" "Vehicles" page
		    And the user click the filter button
		    And the user click on manage filter button
		    And select all boxes
		    Then all check boxes are selected
		    When the user click on reset button
		    Then User can  remove all filterings by using the reset button
		    Examples:
		      | usertype     |
		      | driver       |
		      | sales manager |
		      | store manager |	

	#{color:#00875a}*User Story :* {color}
	#
	#As a user, I should be able to filter "Tags"
	#
	# 
	#
	#{color:#de350b}*_Acceptance Criterias:_*{color}
	#
	#1- Columns should provide at least below methods and:
	#                -> isAnyOF
	#                -> isNotAnyOf 
	# {color:#0747a6}*2- After filtering each method, table should displays corresponding data related to selected method*{color}   
	@TRANS-616 @TRANS-603
	Scenario Outline: Halil - 538 - After filtering each method, table should displays corresponding data related to selected method
		    Given the user is on the login page
		    And the user enters the "<user>" and "UserUser123"
		    When the user navigates to "Fleet", "Vehicles"
		    Then the user should be able to filtering "Tags"
		    And after "<each>" method filtering and after choose "<value>" user should see the filtered data on the table
		
		    Examples:
		      | user            | each          | value   |
		      | user10          | Is Any Of     | Compact |
		      | storemanager80  | Is Not Any Of | Junior  |
		      | salesmanager110 | Is Any Of     | Senior  |
		      | user20          | Is Not Any Of | Sedan   |	

	#{color:#00875a}*User Story :* {color}
	#
	#As a user, I should be able to filter the "Immatriculation Date" and "First Contract Date" columns
	#
	# 
	#
	#{color:#de350b}*_Acceptance Criteria:_*{color}
	#
	#*{color:#0747a6}1-Columns should provide at least below methods:{color}*
	#                *{color:#0747a6}-> equals{color}*
	#                *{color:#0747a6}-> not equals{color}*
	#                *{color:#0747a6}-> earlier than{color}*
	#                *{color:#0747a6}-> later than{color}*
	#                *{color:#0747a6}-> between{color}*
	#                *{color:#0747a6}-> not between{color}*
	#2-After filtering each method, filtered data should be displayed on the table.
	@TRANS-582 @TRANS-603
	Scenario Outline: Halil - 535 - A.C.1 Columns should provide methods
		    Given the user is on the login page
		    And the user enters the "<user>" and "UserUser123"
		    When the user navigates to "Fleet" "Vehicles"
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
		      | user            | password    |
		      | user10          | UserUser123 |
		      | storemanager85  | UserUser123 |
		      | salesmanager110 | UserUser123 |	

	#{color:#00875a}*User Story :* {color}
	#
	#As a user, I should be able to filter the "Last Odometer" column
	#
	# 
	#
	#{color:#de350b}*_Acceptance Criteria:_*{color}
	#
	#1-Columns should provide at least below methods and:
	#                
	#                *{color:#FF0000}->{color}* *{color:#FF0000}between{color}*
	#                -> not between
	#
	#                -> equals
	#
	#                ->not equals
	#                -> more than
	#                -> less than
	#
	#                -> is empty
	#
	#                -> is not empty
	# 2- After filtering each method, table should displays corresponding data related to selected method
	@TRANS-604 @TRANS-603
	Scenario Outline: Last Odometer Between Filtering
		    Given the user is on the login page
		    When the user logged in as "<userType>"
		    And the user navigates to "Fleet", "Vehicles"
		    Then the user select the "Last Odometer", "between" filtering type
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
			

	#*User Story :* 
	#
	#As a user, I should be able to arrange table data
	#
	# 
	#
	#*_Acceptance Criteria:_*
	#
	#1-User can select demanded columns to be displayed via the "grid settings" function
	# 2-User can arrange the sequence of the columns
	# 3-User can sort data (column-based) in ascending or descending order by clicking the column header name
	# 4-User can arrange rows number to be displayed on the page (view per page function)
	# *5-User can  remove all  "sortings" by using the reset button*
	@TRANS-580 @TRANS-603
	Scenario: User can  remove all  "sortings" by using the reset button - different page
		    Given "driver" should be login
		    When user should navigates to Cars page
		    When user take the first row text
		    And user clicks the next page button
		    And user clicks reset button
		    Then first data row needs to be same	

	#User Story : 
	#
	#As a user, I should be able to filter the "Driver" and "Location" columns
	#
	# 
	#
	#Acceptance Criterias:
	#
	#1- Columns should provide at least below methods and:
	#                -> contains
	#                -> does not contain
	#                -> starts with
	#                -> ends with
	#                -> is Equal
	#2- After filtering each method, table should displays corresponding data related to selected method
	@TRANS-618 @TRANS-603
	Scenario Outline: US-010 Columns should provide at least below methods
		 Given The user is on the login page
		    And the user logged in as "<userType>"
		    When the user navigates to "Fleet" "Vehicles"
		    And the user click manage filters and select Driver checkbox
		    And the user click Driver dropdown button
		    Then the user can see at least following methods
		      | Contains         |
		      | Does Not Contain |
		      | Is Equal To      |
		      | Starts With      |
		      | Ends With        |
		      | Is Any Of        |
		      | Is Not Any Of    |
		      | Is Empty         |
		      | Is Not Empty     |
		
		    Examples:
		      | userType      |
		      | driver        |
		     | sales Manager |
		     | store manager |