package com.epam.biaseda.reportportaltest.ui.cucumber.step;

import com.epam.biaseda.reportportaltest.ui.service.LaunchStatisticsChartUIService;
import com.epam.biaseda.reportportaltest.ui.validation.AddNewWidgetLightboxBaseValidation;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class VerifyWizardStepsDefinition {

    private static final String STEP_NUMBER = "STEP NUMBER";
    private static final String STEP_NAME = "STEP NAME";
    private static final String STEP_STATUS = "STEP STATUS";

    @Then("verify Wizard Steps")
    public void verify_wizard_steps(DataTable dataTable) {

        List<Map<String, String>> wizardStepsData = dataTable.asMaps();
        for (Map<String, String> wizardStep : wizardStepsData) {
            AddNewWidgetLightboxBaseValidation.validateWizardSteps(wizardStep.get(STEP_NUMBER), wizardStep.get(STEP_NAME), wizardStep.get(STEP_STATUS));
        }
    }

    @Then("user goes to 3rd step")
    public void user_goes_to_next_step() {
        LaunchStatisticsChartUIService.goToNextStep();
    }
}
