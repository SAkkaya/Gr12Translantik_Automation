@TRANS-548
Feature: 

	#1- All user types can see all vehicle information
	#2- Navigating to page: vehicle submodule under fleet
	#
	#5- User can see total recordings
	@TRANS-547
	Scenario Outline: User should be able to see all vehicle information in a table
		    Given The user logged in as "<userType>"
		    When the user navigates to "Fleet" "Vehicles"
		    Then User should see the table  of vehicle information
		    And user should see total recordings
		    Examples:
		      | userType      |
		      | driver        |
		      | store manager |
		      | sales manager |	

	#Downloading the data for all users
	@TRANS-564
	Scenario Outline: User can download table data in XLS or CSV format (a confirmation message is enough to validate)
		    Given The user logged in as "<userType>"
		    And the user navigates to "Fleet" "Vehicles"
		    When user selects the format XLS or CSV under ExportGrid dropdown
		    Then user succesfully downloaded the table
		    Examples:
		      | userType      |
		      | driver        |
		      | store manager |
		      | sales manager |	

	#4- User can see the total page and change the page number
	@TRANS-586
	Scenario Outline: User can see the total page and change the page number
		 Given The user logged in as "<userType>"
		    When the user navigates to "Fleet" "Vehicles"
		    And user selects different page
		    Then user is on selected page and can see total pages
		    Examples:
		      | userType      |
		      | driver        |
		      | store manager |
		      | sales manager |