package com.epam.biaseda.reportportaltest.ui.cucumber.step;

import com.epam.biaseda.reportportaltest.ui.service.SelectWidgetTypeUIService;
import com.epam.biaseda.reportportaltest.ui.validation.AddNewWidgetLightboxBaseValidation;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyWidgetTypesDefinition {

    @When("user selects {string} Widget Type")
    public void user_selects_widget_type(String widgetType) {
        SelectWidgetTypeUIService.selectWidgetType(widgetType);
    }

    @Then("^user sees under Wizard Steps widget Type \"([\\w\\s]+)\" and description \"([\\S\\s]+)")
    public void user_sees_under_wizard_steps_widget_type_and_description_regex(String widgetType, String description) {
        AddNewWidgetLightboxBaseValidation.validateWidgetInfoBlock(widgetType, description.replaceAll(".$", ""));
    }

    @When("user goes to 2nd step")
    public void user_goes_to_2nd_step() {
        SelectWidgetTypeUIService.goToNextStep();
    }
}
