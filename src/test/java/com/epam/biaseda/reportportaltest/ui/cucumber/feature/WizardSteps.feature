Feature: Wizard Steps

  Background: Open "DEMO DASHBOARD" dashboard
    Given user logins to Report Portal
    When user opens dashboard "DEMO DASHBOARD"
    Then user sees dashboard is not empty

  Scenario: Verifying Wizard Steps
    Given user clicks on Add widget button
    When Add new widget lightbox opened
    Then Verify Wizard Steps
      |STEP NUMBER|STEP NAME          |STEP STATUS|
      |1          |Select widget type |active     |
      |2          |Configure widget   |not started|
      |3          |Save               |not started|
    And user selects "Launch statistics chart" widget type and goes to next step
    Then Verify Wizard Steps
      |STEP NUMBER|STEP NAME          |STEP STATUS|
      |1          |Select widget type |completed  |
      |2          |Configure widget   |active     |
      |3          |Save               |not started|

    And user selects "DEMO_FILTER" filter and goes to next step
    Then Verify Wizard Steps
      |STEP NUMBER|STEP NAME          |STEP STATUS|
      |1          |Select widget type |completed  |
      |2          |Configure widget   |completed  |
      |3          |Save               |active     |