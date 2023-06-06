package com.epam.biaseda.reportportaltest.ui.selenide.validation;

import com.epam.biaseda.reportportaltest.ui.selenide.page.DashboardsPage;
import com.epam.biaseda.reportportaltest.ui.selenide.page.block.TableView;
import com.epam.biaseda.reportportaltest.ui.selenide.validation.constants.DashboardsValidationConstant;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.epam.biaseda.reportportaltest.ui.selenide.validation.constants.DashboardsValidationConstant.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DashboardsUIValidation extends BaseUIValidation {

    public static void validateDashboardsPageHeader() {
        log.debug("Validate Dashboards page header...");
        assertThat($(DashboardsPage.HEADER).getText()).isEqualTo(DashboardsValidationConstant.ALL_DASHBOARDS);
        assertThat($(DashboardsPage.ADD_NEW_DASHBOARD_BUTTON).getText()).isEqualTo(DashboardsValidationConstant.ADD_NEW_DASHBOARD);
        assertThat($(DashboardsPage.TABLE_VIEW_BUTTON).isDisplayed()).isTrue();
        assertThat($(DashboardsPage.GRID_VIEW).isDisplayed()).isTrue();
    }

    public static void validateDashboardsTableViewHeader() {
        log.debug("Validate Dashboards page table view...");
        assertThat($(TableView.DASHBOARD_NAME_HEADER).getText()).isEqualTo(TABLE_HEADER_NAME);
        assertThat($(TableView.DESCRIPTION_HEADER).getText()).isEqualTo(TABLE_HEADER_DESCRIPTION);
        assertThat($(TableView.OWNER_HEADER).getText()).isEqualTo(TABLE_HEADER_OWNER);
        assertThat($(TableView.SHARED_HEADER).getText()).isEqualTo(TABLE_HEADER_SHARED);
        assertThat($(TableView.EDIT_HEADER).getText()).isEqualTo(TABLE_HEADER_EDIT);
        assertThat($(TableView.DELETE_HEADER).getText()).isEqualTo(TABLE_HEADER_DELETE);
    }

    public static void checkDashboardsTableNotEmpty() {
        log.debug("Validate Dashboards table not empty...");
        assertThat($$(TableView.TABLE_ROW_LIST).size()).as("Dashboards table not empty").isGreaterThan(0);
    }
}
