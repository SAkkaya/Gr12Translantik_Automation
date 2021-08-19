Feature: Login

Scenario Outline: Different user types
Given the user is on the login page
When the user logged in as "<userType>"
Then the title should be "Dashboard"

Examples:
| userType      |
| driver        |
| store manager |
| sales manager |