Feature: Widget Types

  Background: Open "DEMO DASHBOARD" dashboard
    Given user logins to Report Portal
    Then user opens dashboard "DEMO DASHBOARD"
    And user clicks on Add widget button

    Scenario Outline: Widget Types Verification
      When user selects "<widget_type>" Widget Type
      Then user sees under Wizard Steps widget Type "<widget_type>" and description "<description>"
      Examples:
        | widget_type                         | description |
        | Launch statistics chart             | - in "Launch mode" shows the growth trend in the number of test cases with each selected statuses from run to run,\n- in "Timeline mode" shows sum, distributed by dates. |
        | Launches duration chart             | Shows duration of the selected launches. |
        | Project activity panel              | Shows all activities occurring on the project. |
        | Investigated percentage of launches | - in "Launch Mode" shows whether the launches are analyzed or not (the percentage of "Investigated"/"To Investigate") from run to run,\n- in "Timeline Mode" shows percentage of "Investigated"/"To Investigate" tests in all runs per day distributed by dates. |
        | Unique bugs table                   | Shows real identified bugs, posted to the Bug Tracking System, and existing in the BTS bugs, loaded on the project. |
        | Failed cases trend chart            | Shows the trend of growth in the number of failed test cases from run to run. |
        | Different launches comparison chart | Allows to compare statistics for 2 last launches side by side. |