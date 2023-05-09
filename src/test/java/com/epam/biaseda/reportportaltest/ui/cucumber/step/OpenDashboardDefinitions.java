package com.epam.biaseda.reportportaltest.ui.cucumber.step;

import com.epam.biaseda.reportportaltest.ui.logic.LoginServiceUILogic;
import com.epam.biaseda.reportportaltest.ui.service.DashboardsUIService;
import com.epam.biaseda.reportportaltest.ui.validation.DashboardUIValidation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpenDashboardDefinitions {

    @Given("user logins to Report Portal")
    public void user_logins_to_report_portal() {
        LoginServiceUILogic.login();
    }
    @When("user opens dashboard {string}")
    public void user_opens_dashboard(String dashboardTitle) {
        DashboardsUIService.openDashboard(dashboardTitle);
    }
    @Then("user sees dashboard is not empty")
    public void user_sees_dashboard_is_not_empty() {
        DashboardUIValidation.checkDashboardsTableNotEmpty();
    }

}
