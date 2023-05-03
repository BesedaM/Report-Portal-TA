package com.epam.biaseda.reportportaltest.ui.validation;

import com.epam.biaseda.reportportaltest.ui.page.DashboardPage;
import com.epam.biaseda.reportportaltest.ui.page.DeleteWidgetPopover;
import com.epam.biaseda.reportportaltest.ui.page.block.Widget;
import com.epam.biaseda.reportportaltest.ui.validation.constants.DashboardValidationConstant;

import static org.assertj.core.api.Assertions.assertThat;

public class DashboardUIValidation extends BaseUIValidation {

    public static void validateDashboardPageHeader(String selectedDashboardTitle) {
        log.debug("Validate Opened Dashboard page header elements...");
        StringBuilder descriptionReportBuilder = createDescriptionReportBuilder();
        DashboardPage dashboardPage = new DashboardPage();
        assertThat(dashboardPage.getAllDashBoardsLink().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, dashboardPage.getAllDashBoardsLink().getName())).isEqualTo(DashboardValidationConstant.ALL_DASHBOARDS);
        assertThat(dashboardPage.getSelectedDashboardTitle().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, dashboardPage.getSelectedDashboardTitle().getName())).isEqualTo(selectedDashboardTitle);
        assertThat(dashboardPage.getAddNewDashboardButton().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, dashboardPage.getAddNewDashboardButton().getName())).isEqualTo(DashboardValidationConstant.ADD_NEW_DASHBOARD);
        assertThat(dashboardPage.getEditButton().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, dashboardPage.getEditButton().getName())).isEqualTo(DashboardValidationConstant.EDIT);
        assertThat(dashboardPage.getFullScreenButton().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, dashboardPage.getFullScreenButton().getName())).isEqualTo(DashboardValidationConstant.FULL_SCREEN);
        assertThat(dashboardPage.getDeleteButton().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, dashboardPage.getDeleteButton().getName())).isEqualTo(DashboardValidationConstant.DELETE);
        assertThat(dashboardPage.getPrintButton().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, dashboardPage.getPrintButton().getName())).isEqualTo(DashboardValidationConstant.PRINT);
        log.debug(descriptionReportBuilder.toString());
    }

    public static void checkDashboardsTableNotEmpty() {
        log.debug("Validate Dashboard not empty...");
        StringBuilder descriptionReportBuilder = createDescriptionReportBuilder();
        assertThat(new DashboardPage().getWidgets().size())
                .as(String.format("Dashboard is not empty")).isGreaterThan(0);
        log.debug(descriptionReportBuilder.toString());
    }

    public static void validateWidget(String widgetName, String widgetType, String widgetViewType) {
        log.debug(String.format("Validate widget %s...", widgetName));
        StringBuilder descriptionReportBuilder = createDescriptionReportBuilder();
        Widget widget = new DashboardPage().getWidget(widgetName);
        assertThat(widget.getWidgetType().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, widget.getWidgetType().getName())).isEqualTo(widgetType);
        assertThat(widget.getWidgetViewType().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, widget.getWidgetViewType().getName())).isEqualTo(widgetViewType);
        log.debug(descriptionReportBuilder.toString());
    }

    public static void validateDeleteWidgetPopover() {
        log.debug("Check Delete widget popover is opened...");
        StringBuilder descriptionReportBuilder = createDescriptionReportBuilder();
        DeleteWidgetPopover popover = new DashboardPage().getDeleteWidgetPopover();
        assertThat(popover.getTitle().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, popover.getTitle().getName())).isEqualTo(DashboardValidationConstant.DELETE_WIDGET_POPOVER_TITLE);
        assertThat(popover.getCancelButton().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, popover.getCancelButton().getName())).isEqualTo(DashboardValidationConstant.CANCEL);
        assertThat(popover.getDeleteButton().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, popover.getDeleteButton().getName())).isEqualTo(DashboardValidationConstant.DELETE);
        log.debug(descriptionReportBuilder.toString());
    }
}
