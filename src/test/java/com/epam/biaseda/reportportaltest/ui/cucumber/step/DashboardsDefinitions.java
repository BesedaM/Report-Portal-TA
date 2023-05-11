package com.epam.biaseda.reportportaltest.ui.cucumber.step;

import com.epam.biaseda.reportportaltest.ui.service.DashboardsUIService;
import io.cucumber.java.en.When;

public class DashboardsDefinitions {

    @When("user opens dashboard {string}")
    public void user_opens_dashboard(String dashboardTitle) {
        DashboardsUIService.openDashboard(dashboardTitle);
    }
}
