package com.epam.biaseda.reportportaltest.ui.cucumber.step;

import com.epam.biaseda.reportportaltest.ui.service.DashboardUIService;
import com.epam.biaseda.reportportaltest.ui.service.LaunchStatisticsChartUIService;
import com.epam.biaseda.reportportaltest.ui.service.SelectWidgetTypeUIService;
import com.epam.biaseda.reportportaltest.ui.validation.AddNewWidgetLightboxBaseValidation;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class VerifyWizardStepsDefinition {

    private static final String STEP_NUMBER = "STEP NUMBER";
    private static final String STEP_NAME = "STEP NAME";
    private static final String STEP_STATUS = "STEP STATUS";

    @When("Add new widget lightbox opened")
    public void add_new_widget_lightbox_opened() {
        AddNewWidgetLightboxBaseValidation.validateLightboxHeader();
    }

    @Then("Verify Wizard Steps")
    public void verify_wizard_steps(DataTable dataTable) {

        List<Map<String, String>> wizardStepsData = dataTable.asMaps();
        for (Map<String, String> wizardStep : wizardStepsData) {
            AddNewWidgetLightboxBaseValidation.validateWizardSteps(wizardStep.get(STEP_NUMBER), wizardStep.get(STEP_NAME), wizardStep.get(STEP_STATUS));
        }
    }

    @Then("user selects {string} widget type and goes to next step")
    public void user_selects_widget_type_and_goes_to_next_step(String widgetType) {
        SelectWidgetTypeUIService.selectWidgetType(widgetType);
        SelectWidgetTypeUIService.goToNextStep();
    }

    @Then("user selects {string} filter and goes to next step")
    public void user_selects_filter_and_goes_to_next_step(String filterName) {
        LaunchStatisticsChartUIService.selectFilter(filterName);
        LaunchStatisticsChartUIService.goToNextStep();
    }
}
