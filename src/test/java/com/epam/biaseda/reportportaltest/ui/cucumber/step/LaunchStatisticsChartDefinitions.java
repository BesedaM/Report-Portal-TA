package com.epam.biaseda.reportportaltest.ui.cucumber.step;

import com.epam.biaseda.reportportaltest.ui.service.LaunchStatisticsChartUIService;
import com.epam.biaseda.reportportaltest.ui.validation.LaunchStatisticsChartUIValidation;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.List;

public class LaunchStatisticsChartDefinitions {

    @Then("user opens criteria dropdown of \"Launch statistics chart\" Widget")
    public void user_opens_criteria_dropdown_of_widget() {
        LaunchStatisticsChartUIService.openCriteriaForWidgetDropdown();
    }

    @Then("user selects {string} filter")
    public void user_selects_filter(String filterName) {
        LaunchStatisticsChartUIService.selectFilter(filterName);
    }

    @Then("user verifies \"Launch statistics chart\" criteria dropdown")
    public void user_verifies_criteria_dropdown_list(DataTable dataTable) {
        List<String> criterialist = dataTable.asList();
        for (String criteria : criterialist) {
            LaunchStatisticsChartUIValidation.verifyCriteriaForWidgetDropdownMenu(criteria);
        }
    }
}
