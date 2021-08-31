@TRANS-533
Feature:

	#AC 1 - All users can see the delete option by hovering over ... on the table at the end of each row
	@TRANS-587
	Scenario Outline: All users can see the delete option by hovering over
		            Given The user logged in as "<userType>"
				    And the user navigates to "Fleet" "Vehicles"
				    When User hovers over on ... at the end of each row in the table
				    Then user should see the delete option in the opened menu
				    Examples:
				      | userType      |
				      | driver        |
				      | store manager |
				      | sales manager |
  	#2-"You do not have permission to perform this action." message should be displayed if the driver attempts to delete a car.
	@TRANS-588
	Scenario: The driver attempts to delete a car
		Given The user logged in as "driver"
		And the user navigates to "Fleet" "Vehicles"
		When User clicks on delete vehicle button
		And User confirms delete by clicking yes
		Then no permission message should be displayed

		#3- AC3- Driver can NOT see "delete" button on "General Information" page
	@TRANS-589
	Scenario: Verify that the driver should not see delete button on General Information page
		Given The user logged in as "driver"
		And the user navigates to "Fleet" "Vehicles"
		When the user clicks on one of the cars in the table
		Then the user should not be able to see delete button on the page

		#AC4- Sales manager and store manager can reach the delete button on the general information page
	@TRANS-590
	Scenario Outline: Verify that sales manager and store manager can reach the delete button on the general information page
		Given The user logged in as "<userType>"
		And the user navigates to "Fleet" "Vehicles"
		When the user clicks on one of the cars in the table
		Then the user should be able to see delete button on the page
		Examples:
			| userType      |
			| store manager |
			| sales manager |

			#AC5- "Delete Confirmation" pop up should be displayed when the user clicks on the delete button
	@TRANS-591
	Scenario Outline: Verify that Delete Confirmation pop up should be displayed when the user clicks on the delete button
		Given The user logged in as "<userType>"
		And the user navigates to "Fleet" "Vehicles"
		When User clicks on delete vehicle button
		Then delete confirmation pop up should be displayed
		Examples:
			| userType      |
			| store manager |
			| sales manager |

			#AC6- After deleting a car, "Car deleted" message should be displayed and the corresponding vehicle should be removed from the table
	@TRANS-592
	Scenario Outline: Verify that car is successfully deleted and deleted message is displayed
		Given The user logged in as "<userType>"
		And the user navigates to "Fleet" "Vehicles"
		When User clicks on delete vehicle button
		And User confirms delete by clicking yes
		Then car is succesfully deleted and deleted message is displayed
		Examples:
			| userType      |
			| store manager |
			| sales manager |
