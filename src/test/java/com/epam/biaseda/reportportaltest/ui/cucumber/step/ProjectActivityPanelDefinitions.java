package com.epam.biaseda.reportportaltest.ui.cucumber.step;

import com.epam.biaseda.reportportaltest.ui.service.ProjectActivityPanelUIService;
import com.epam.biaseda.reportportaltest.ui.validation.ProjectActivityPanelUIValidation;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.List;

public class ProjectActivityPanelDefinitions {

    @Then("user opens criteria dropdown of \"Project activity panel\" Widget")
    public void user_opens_criteria_dropdown_of_widget() {
        ProjectActivityPanelUIService.openCriteriaForWidgetDropdown();
    }

    @Then("user verifies \"Project activity panel\" criteria dropdown")
    public void user_verifies_criteria_dropdown_list(DataTable dataTable) {
        List<String> criterialist = dataTable.asList();
        for (String criteria : criterialist) {
            ProjectActivityPanelUIValidation.verifyCriteriaForWidgetDropdownMenu(criteria);
        }
    }
}
