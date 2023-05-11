Feature: Wizard Steps

  Background: Open "DEMO DASHBOARD" dashboard
    Given user logins to Report Portal
    When user opens dashboard "DEMO DASHBOARD"

  Rule: Status of Wizard Step must be changed when navigating from one step to another

  Example: Verifying Wizard Steps
    Given user clicks on Add widget button
    When Add new widget lightbox opened
    Then verify Wizard Steps
      |STEP NUMBER|STEP NAME          |STEP STATUS|
      |1          |Select widget type |active     |
      |2          |Configure widget   |not started|
      |3          |Save               |not started|
    And user selects "Launch statistics chart" Widget Type
    And user goes to 2nd step
    Then verify Wizard Steps
      |STEP NUMBER|STEP NAME          |STEP STATUS|
      |1          |Select widget type |completed  |
      |2          |Configure widget   |active     |
      |3          |Save               |not started|

    And user selects "DEMO_FILTER" filter
    And user goes to 3rd step
    Then verify Wizard Steps
      |STEP NUMBER|STEP NAME          |STEP STATUS|
      |1          |Select widget type |completed  |
      |2          |Configure widget   |completed  |
      |3          |Save               |active     |