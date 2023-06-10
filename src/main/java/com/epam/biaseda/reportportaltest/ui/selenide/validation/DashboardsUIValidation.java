package com.epam.biaseda.reportportaltest.ui.selenide.validation;

import com.epam.biaseda.reportportaltest.ui.selenide.page.DashboardsPage;
import com.epam.biaseda.reportportaltest.ui.selenide.page.TableView;
import com.epam.biaseda.reportportaltest.ui.selenide.validation.constants.DashboardsValidationConstant;

import static com.codeborne.selenide.Selenide.*;
import static com.epam.biaseda.reportportaltest.ui.selenide.validation.constants.DashboardsValidationConstant.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DashboardsUIValidation extends BaseUIValidation {

    private static DashboardsPage dashboardsPage = page(new DashboardsPage());
    private static TableView tableView = page(new TableView());


    public static void validateDashboardsPageHeader() {
        log.debug("Validate Dashboards page header...");
        assertThat(dashboardsPage.getHeader().getText()).isEqualTo(DashboardsValidationConstant.ALL_DASHBOARDS);
        assertThat(dashboardsPage.getAddNewDashboardButton().getText()).isEqualTo(DashboardsValidationConstant.ADD_NEW_DASHBOARD);
        assertThat(dashboardsPage.getTableViewButton().isDisplayed()).isTrue();
        assertThat(dashboardsPage.getGridView().isDisplayed()).isTrue();
    }

    public static void validateDashboardsTableViewHeader() {
        log.debug("Validate Dashboards page table view...");
        assertThat(tableView.getDashboardNameHeader().getText()).isEqualTo(TABLE_HEADER_NAME);
        assertThat(tableView.getDescriptionHeader().getText()).isEqualTo(TABLE_HEADER_DESCRIPTION);
        assertThat(tableView.getOwnerHeader().getText()).isEqualTo(TABLE_HEADER_OWNER);
        assertThat(tableView.getSharedHeader().getText()).isEqualTo(TABLE_HEADER_SHARED);
        assertThat(tableView.getEditHeader().getText()).isEqualTo(TABLE_HEADER_EDIT);
        assertThat(tableView.getDeleteHeader().getText()).isEqualTo(TABLE_HEADER_DELETE);
    }

    public static void checkDashboardsTableNotEmpty() {
        log.debug("Validate Dashboards table not empty...");
        assertThat(tableView.getTableRowList().size()).as("Dashboards table not empty").isGreaterThan(0);
    }
}
