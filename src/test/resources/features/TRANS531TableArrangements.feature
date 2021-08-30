@TRANS-575
Feature:

	#*User Story :* 
	#
	#As a user, I should be able to arrange table data
	#
	# 
	#
	#*_Acceptance Criteria:_*
	#
	#*1-User can select demanded columns to be displayed via the "grid settings" function*
	# 2-User can arrange the sequence of the columns
	# 3-User can sort data (column-based) in ascending or descending order by clicking the column header name
	# 4-User can arrange rows number to be displayed on the page (view per page function)
	# 5-User can  remove all  "sortings" by using the reset button
  @TRANS-573
  Scenario: User can select demanded columns to be displayed via the "grid settings" function
    Given "driver" should be login
    When user should navigates to Cars page
    When user clicks the select all button which belongs to grid settings
    When all selected options should be seen, all not selected options shouldn't be seen

	#*User Story :* 
	#
	#As a user, I should be able to arrange table data
	#
	# 
	#
	#*_Acceptance Criteria:_*
	#
	#1-User can select demanded columns to be displayed via the "grid settings" function
	# *2-User can arrange the sequence of the columns*
	# 3-User can sort data (column-based) in ascending or descending order by clicking the column header name
	# 4-User can arrange rows number to be displayed on the page (view per page function)
	# 5-User can  remove all  "sortings" by using the reset button
  @TRANS-574
  Scenario: User can arrange the sequence of the columns
    Given "driver" should be login
    When user should navigates to Cars page
    Given user clicks the select all button which belongs to grid settings
    When drag and drop any element, needs to be changed it's order

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
	# *3-User can sort data (column-based) in ascending or descending order by clicking the column header name*
	# 4-User can arrange rows number to be displayed on the page (view per page function)
	# 5-User can  remove all  "sortings" by using the reset button
  @TRANS-576
  Scenario Outline: User can sort data (column-based) in ascending or descending order by clicking the column header name
    Given "driver" should be login
    When user should navigates to Cars page
    When user clicks the <number> header
    Then sort needs to be ascending order by <number>
    When user clicks the <number> header
    Then sort needs to be descending order by <number>
    Examples:
      | number |
      | 0      |
      | 2      |
      | 3      |
      | 5      |
      | 9      |
      | 12     |
      | 13     |
      | 14     |


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
	# *4-User can arrange rows number to be displayed on the page (view per page function)*
	# 5-User can  remove all  "sortings" by using the reset button
  @TRANS-577
  Scenario Outline: User can arrange rows number to be displayed on the page (view per page function - <option>)
    Given "driver" should be login
    When user should navigates to Cars page
    Given user select for view page number as <option>
    Then there should be <option> row in the page
    Examples:
      | option |
      | 10     |
      | 25     |
      | 50     |
      | 100    |


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
  @TRANS-578
  Scenario Outline: User can  remove all  "sortings" by using the reset button - view page button
    Given "driver" should be login
    When user should navigates to Cars page
    When user select for view page number as <option1>
    And user clicks reset button
    Then there should be 25 row in the page
    Examples:
      | option1 |
      | 10      |
      | 25      |
      | 50      |
      | 100     |


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
  @TRANS-579
  Scenario Outline: User can  remove all  "sortings" by using the reset button - sortings
    Given "driver" should be login
    When user should navigates to Cars page
    When user take the first row text
    When user clicks the select all button which belongs to grid settings
    And user clicks <tableHeader-data>
    And user clicks reset button
    Then first data row needs to be same
    Examples:
      | tableHeader-data |
      | 1                |
      | 2                |
      | 3                |
      | 4                |
      | 5                |
      | 6                |
      | 7                |
      | 8                |
      | 9                |
      | 10               |
      | 11               |
      | 12               |
      | 13               |
      | 14               |
      | 15               |
      | 16               |
      | 17               |


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
  @TRANS-580
  Scenario: User can  remove all  "sortings" by using the reset button - different page
    Given "driver" should be login
    When user should navigates to Cars page
    When user take the first row text
    And user clicks the next page button
    And user clicks reset button
    Then first data row needs to be same