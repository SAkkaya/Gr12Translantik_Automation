Feature: Add Event

  Scenario Outline: Users can access the "Add Event" page from the "General Information" page in the Vehicles sub-module

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


  Scenario: Driver can NOT add an event
    Given the user is on the login page
    When the user logged in as "driver"
    And the user navigates to "Fleet", "Vehicles"
    And the user click on any car information row
    And the user should be able to see the "General Information" page
    Then Driver should not able to click on AddEvent button

  @wip1
  Scenario Outline: Compulsory fields
    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user navigates to "Fleet", "Vehicles"
    And the user click on any car information row
    And the user should be able to see the "General Information" page
    And the user click on AddEvent button
    Then compulsory fields are as below

      | Title                  |
      | Owner                  |
      | Organizer display name |
      | Organizer email        |
      | Start                  |
      | End                    |

    Examples:
      | userType      |
      | store manager |
      | sales manager |

  Scenario Outline: Blank message should be displayed if any compulsoryField is not filled.

    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user navigates to "Fleet", "Vehicles"
    And the user click on any car information row
    And the user click on AddEvent button
    And the user send empty text to compulsory fields
    And the user click on save button.
    Then "This value should not be blank." should be displayed

    Examples:
      | userType      |
      | store manager |
      | sales manager |

  Scenario Outline: color marking fro urgency level

    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user navigates to "Fleet", "Vehicles"
    And the user click on any car information row
    And the user click on AddEvent button
    Then User should be able to click on the event colored marks to determine urgency level

    Examples:
      | userType      |
      | store manager |
      | sales manager |


  Scenario Outline: color marking fro urgency level

    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user navigates to "Fleet", "Vehicles"
    And the user click on any car information row
    And the user click on AddEvent button

    Then User should able to mark on on All-day event" button

    Examples:
      | userType      |
      | store manager |
      | sales manager |

  Scenario Outline: color marking fro urgency level

    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user navigates to "Fleet", "Vehicles"
    And the user click on any car information row
    And the user click on AddEvent button
    Then Occurrence interval options listed below are available
      | Daily   |
      | Weekly  |
      | Monthly |
      | Yearly  |

    And  Ending options below are available

      | Never |
      | After |
      | By    |


    Examples:
      | userType      |
      | store manager |
      | sales manager |


  @wip
  Scenario Outline: color marking fro urgency level

    Given the user is on the login page
    When the user logged in as "<userType>"
    And the user navigates to "Fleet", "Vehicles"
    And the user click on any car information row
    Then All Users should be able to see all events in the General information page


    Examples:
      | userType      |
      | driver        |
      | store manager |
      | sales manager |


