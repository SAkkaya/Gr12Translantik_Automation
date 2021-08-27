@TRANS-563
Feature: filter manage options

	#As a user, I should be able to filter table
	#
	#
	#
	#{color:#de350b}*_Acceptance Criteria:_*{color}
	#
	#*1- Manage filter should be hidden as default*
	#
	#2- Manage filter options should be displayed once the user clicks on the filter button
	#3- User can apply filtering for each of the data columns on the page
	#
	#4-User can  remove all "filterings" by using the reset button
	#5- All user types can perform filtering actions
	#6- Application supports multiple filtering of columns
  @TRANS-557
  Scenario Outline: Hidden Manage Filter
    Given the "<usertype>" user is logged in
    When the user navigates to "Fleet" "Vehicles" page
    Then Manage filters should be hidden
    Examples:
      | usertype     |
      | driver       |
      | sales manager |
      | store manager |

	#As a user, I should be able to filter table
	#
	#
	#
	#{color:#de350b}*_Acceptance Criteria:_*{color}
	#
	#1- Manage filter should be hidden as default
	#
	#*2- Manage filter options should be displayed once the user clicks on the filter button*
	# 3- User can apply filtering for each of the data columns on the page
	#
	#4-User can  remove all "filterings" by using the reset button
	# 5- All user types can perform filtering actions
	# 6- Application supports multiple filtering of columns
  @TRANS-558
  Scenario Outline: After Clicking filter , manage Filter options appears
    Given the "<usertype>" user is logged in
    When the user navigates to "Fleet" "Vehicles" page
    And the user click the filter button
    Then Manage filter options should be displayed after clicking
    Examples:
      | usertype     |
      | driver       |
      | sales manager |
      | store manager |

	#As a user, I should be able to filter table
	#
	#
	#
	#{color:#de350b}*_Acceptance Criteria:_*{color}
	#
	#1- Manage filter should be hidden as default
	#
	#2- Manage filter options should be displayed once the user clicks on the filter button
	# *3- User can apply filtering for each of the data columns on the page*
	#
	#4-User can  remove all "filterings" by using the reset button
	# *5- All user types can perform filtering actions*
	# 6- Application supports multiple filtering of columns
  @TRANS-559
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
	#2- Manage filter options should be displayed once the user clicks on the filter button
	# 3- User can apply filtering for each of the data columns on the page
	#
	#*4-User can  remove all "filterings" by using the reset button*
	# 5- All user types can perform filtering actions
	# 6- Application supports multiple filtering of columns
  @TRANS-560
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
	#As a user, I should be able to filter table
	#
	#
	#
	#{color:#de350b}*_Acceptance Criteria:_*{color}
	#
	#1- Manage filter should be hidden as default
	#
	#2- Manage filter options should be displayed once the user clicks on the filter button
	# 3- User can apply filtering for each of the data columns on the page
	#
	#4-User can  remove all "filterings" by using the reset button
	# 5- All user types can perform filtering actions
	# *6- Application supports multiple filtering of columns*
  @TRANS-561
  Scenario Outline: multiple filtering of columns
    Given the "<usertype>" user is logged in
    When the user navigates to "Fleet" "Vehicles" page
    And the user click the filter button
    And the user click on manage filter button
    And the user click on multiple options
    When the user sends values for the Licence Plate and Tags
    Then the application should be able to support multiple filtering of columns


    Examples:
      | usertype     |
      | driver       |
      | sales manager |
      | store manager |
