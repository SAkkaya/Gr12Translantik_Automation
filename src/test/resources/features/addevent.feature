
  Feature: Add Event

   Scenario Outline : Users can access the "Add Event" page from the "General Information" page in the Vehicles sub-module

      Given the user is on the login page
       When the user logged in as "<userType>"
       And the user navigates to "Fleet", "Vehicles"
       And the user click on any car information row
       Then the user should be able to see the "General Information" page


     Examples:

       | userType      |
       | driver        |
       | store manager |
       | sales manager |