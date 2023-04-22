package com.epam.biaseda.reportportaltest.ui.validation;

import com.epam.biaseda.reportportaltest.ui.page.DashboardsPage;
import com.epam.biaseda.reportportaltest.ui.validation.constants.DashboardsValidationConstant;

import static org.assertj.core.api.Assertions.assertThat;

public class DashboardsUIValidation extends BaseUIValidation {

    public static void validateDashboardsPageHeader() {
        log.debug("Validate Dashboards page header...");
        StringBuilder descriptionReportBuilder=createDescriptionReportBuilder();
        DashboardsPage dashboardsPage = new DashboardsPage();
        assertThat(dashboardsPage.getHeader().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, dashboardsPage.getHeader().getName())).isEqualTo(DashboardsValidationConstant.ALL_DASHBOARDS);
        assertThat(dashboardsPage.getAddNewDashboardButton().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, dashboardsPage.getAddNewDashboardButton().getName())).isEqualTo(DashboardsValidationConstant.ADD_NEW_DASHBOARD);
        assertThat(dashboardsPage.getTableViewButton().isDisplayed())
                .as(String.format(VALIDATE_PRESENCE_PATTERN, dashboardsPage.getTableViewButton().getName())).isTrue();
        assertThat(dashboardsPage.getGridView().isDisplayed())
                .as(String.format(VALIDATE_PRESENCE_PATTERN, dashboardsPage.getGridViewButton().getName())).isTrue();
        log.debug(descriptionReportBuilder.toString());
    }

    public static void validateDashboardsTableViewHeader() {
        DashboardsTableViewUIValidation.validateDashboardsTableview();
    }

    public static void checkDashboardsTableNotEmpty() {
        DashboardsTableViewUIValidation.checkDashboardsTableNotEmpty();
    }
}
