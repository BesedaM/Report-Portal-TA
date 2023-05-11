package com.epam.biaseda.reportportaltest.ui.cucumber.step;

import com.epam.biaseda.reportportaltest.ui.service.DashboardUIService;
import com.epam.biaseda.reportportaltest.ui.validation.DashboardUIValidation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DashboardDefinitions {

    @Then("user sees dashboard is not empty")
    public void user_sees_dashboard_is_not_empty() {
        DashboardUIValidation.checkDashboardsTableNotEmpty();
    }

    @Given("user clicks on Add widget button")
    public void user_clicks_on_add_widget_button() {
        DashboardUIService.addNewWidget();
    }
}
