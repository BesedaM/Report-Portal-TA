package com.epam.biaseda.reportportaltest.ui.validation;

import com.epam.biaseda.reportportaltest.ui.page.DashboardsPage;
import com.epam.biaseda.reportportaltest.ui.page.block.DashboardsTableView;
import com.epam.biaseda.reportportaltest.ui.validation.constants.DashboardsValidationConstant;

import static org.assertj.core.api.Assertions.assertThat;

class DashboardsTableViewUIValidation extends BaseUIValidation {

    public static void validateDashboardsTableview() {
        log.debug("Validate Dashboards page table view...");
        StringBuilder descriptionReportBuilder = createDescriptionReportBuilder();
        DashboardsTableView dashboardsTableView = new DashboardsPage().getTableView();
        assertThat(dashboardsTableView.getDashboardNameHeader().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, dashboardsTableView.getDashboardNameHeader().getName()))
                .isEqualTo(DashboardsValidationConstant.TABLE_HEADER_NAME);
        assertThat(dashboardsTableView.getDescriptionHeader().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, dashboardsTableView.getDescriptionHeader().getName()))
                .isEqualTo(DashboardsValidationConstant.TABLE_HEADER_DESCRIPTION);
        assertThat(dashboardsTableView.getOwnerHeader().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, dashboardsTableView.getOwnerHeader().getName()))
                .isEqualTo(DashboardsValidationConstant.TABLE_HEADER_OWNER);
        assertThat(dashboardsTableView.getSharedHeader().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, dashboardsTableView.getSharedHeader().getName()))
                .isEqualTo(DashboardsValidationConstant.TABLE_HEADER_SHARED);
        assertThat(dashboardsTableView.getEditHeader().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, dashboardsTableView.getEditHeader().getName()))
                .isEqualTo(DashboardsValidationConstant.TABLE_HEADER_EDIT);
        assertThat(dashboardsTableView.getDeleteHeader().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, dashboardsTableView.getDeleteHeader().getName()))
                .isEqualTo(DashboardsValidationConstant.TABLE_HEADER_DELETE);
        log.debug(descriptionReportBuilder.toString());
    }

    public static void checkDashboardsTableNotEmpty() {
        log.debug("Validate Dashboards table not empty...");
        StringBuilder descriptionReportBuilder = createDescriptionReportBuilder();
        DashboardsTableView dashboardsTableView = new DashboardsPage().getTableView();
        assertThat(dashboardsTableView.getTableRowList().size())
                .as(String.format("Dashboards table not empty")).isGreaterThan(0);
        log.debug(descriptionReportBuilder.toString());
    }
}
