Feature: Widget Criteria

  Background: Open "DEMO DASHBOARD" dashboard
    Given user logins to Report Portal
    Then user opens dashboard "DEMO DASHBOARD"
    And user clicks on Add widget button

    Scenario: Verify Launch Statistics Chart Criteria
      When user selects "Launch statistics chart" Widget Type
      And user goes to 2nd step
      Then user opens criteria dropdown of "Launch statistics chart" Widget
      And user verifies "Launch statistics chart" criteria dropdown
        | Total             |
        | Passed            |
        | Failed            |
        | Skipped           |
        | Total product bugs|
        | Product Bug       |
        | Blocker           |
        | Minor Bug         |
        | Automation Bug    |
        | System Issue      |
        | To Investigate    |

    Scenario: Verify Project Activity Panel Criteria
      When user selects "Project activity panel" Widget Type
      And user goes to 2nd step
      Then user opens criteria dropdown of "Project activity panel" Widget
      And user verifies "Project activity panel" criteria dropdown
        | Start launch            |
        | Finish launch           |
        | Delete launch           |
        | Actions with issues     |
        | Add, register user      |
        | Update dashboard        |
        | Update filter           |
        | Update integration      |
        | Update project settings |
        | Update defect types     |
        | Import                  |