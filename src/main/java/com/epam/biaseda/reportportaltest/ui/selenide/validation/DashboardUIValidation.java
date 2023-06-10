package com.epam.biaseda.reportportaltest.ui.selenide.validation;

import com.epam.biaseda.reportportaltest.ui.selenide.page.DashboardPage;
import com.epam.biaseda.reportportaltest.ui.selenide.page.block.DeleteWidgetPopover;
import com.epam.biaseda.reportportaltest.ui.selenide.page.block.Widget;
import com.epam.biaseda.reportportaltest.ui.selenide.validation.constants.DashboardValidationConstant;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class DashboardUIValidation extends BaseUIValidation {

    private static DashboardPage dashboardPage = page(new DashboardPage());

    public static void validateDashboardPageHeader(String selectedDashboardTitle) {
        log.debug("Validate Opened Dashboard page header elements...");
        assertThat(dashboardPage.getAllDashBoardsLink().getText()).isEqualTo(DashboardValidationConstant.ALL_DASHBOARDS);
        assertThat(dashboardPage.getSelectedDashboardTitle().getText()).isEqualTo(selectedDashboardTitle);
        assertThat(dashboardPage.getAddNewDashboardButton().getText()).isEqualTo(DashboardValidationConstant.ADD_NEW_DASHBOARD);
        assertThat(dashboardPage.getEditButton().getText()).isEqualTo(DashboardValidationConstant.EDIT);
        assertThat(dashboardPage.getFullScreenButton().getText()).isEqualTo(DashboardValidationConstant.FULL_SCREEN);
        assertThat(dashboardPage.getDeleteButton().getText()).isEqualTo(DashboardValidationConstant.DELETE);
        assertThat(dashboardPage.getPrintButton().getText()).isEqualTo(DashboardValidationConstant.PRINT);
    }

    public static void checkDashboardsTableNotEmpty() {
        log.debug("Validate Dashboard not empty...");
        assertThat(dashboardPage.getWidgetList().size()).isGreaterThan(0);
    }

    public static void verifyWidgetPresentsOnDashboard(String widgetName) {
        log.debug(String.format("Verify widget %s present on Dashboard...", widgetName));
        assertThatNoException().isThrownBy(() -> dashboardPage.getWidget(widgetName));
    }

    public static void validateWidget(String widgetName, String widgetType, String widgetViewType) {
        log.debug(String.format("Validate widget %s...", widgetName));
        Widget widget = dashboardPage.getWidget(widgetName);
        assertThat(widget.getType().getText()).isEqualTo(widgetType);
        assertThat(widget.getViewType().getText()).isEqualTo(widgetViewType);
    }

    public static void validateDeleteWidgetPopover() {
        log.debug("Check Delete widget popover is opened...");
        DeleteWidgetPopover popover = dashboardPage.getDeleteWidgetPopover();
        assertThat(popover.getTitle().getText()).isEqualTo(DashboardValidationConstant.DELETE_WIDGET_POPOVER_TITLE);
        assertThat(popover.getCancelButton().getText()).isEqualTo(DashboardValidationConstant.CANCEL);
        assertThat(popover.getDeleteButton().getText()).isEqualTo(DashboardValidationConstant.DELETE);
    }
}
