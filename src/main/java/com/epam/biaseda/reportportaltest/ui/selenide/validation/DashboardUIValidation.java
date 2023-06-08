package com.epam.biaseda.reportportaltest.ui.selenide.validation;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import com.epam.biaseda.reportportaltest.ui.selenide.page.DashboardPage;
import com.epam.biaseda.reportportaltest.ui.selenide.page.block.DeleteWidgetPopover;
import com.epam.biaseda.reportportaltest.ui.selenide.page.block.Widget;
import com.epam.biaseda.reportportaltest.ui.selenide.validation.constants.DashboardValidationConstant;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;

public class DashboardUIValidation extends BaseUIValidation {

    public static void validateDashboardPageHeader(String selectedDashboardTitle) {
        log.debug("Validate Opened Dashboard page header elements...");
        assertThat($(DashboardPage.ALL_DASH_BOARDS_LINK).getText()).isEqualTo(DashboardValidationConstant.ALL_DASHBOARDS);
        assertThat($(DashboardPage.SELECTED_DASHBOARD_TITLE).getText()).isEqualTo(selectedDashboardTitle);
        assertThat($(DashboardPage.ADD_NEW_DASHBOARD_BUTTON).getText()).isEqualTo(DashboardValidationConstant.ADD_NEW_DASHBOARD);
        assertThat($(DashboardPage.EDIT_BUTTON).getText()).isEqualTo(DashboardValidationConstant.EDIT);
        assertThat($(DashboardPage.FULL_SCREEN_BUTTON).getText()).isEqualTo(DashboardValidationConstant.FULL_SCREEN);
        assertThat($(DashboardPage.DELETE_BUTTON).getText()).isEqualTo(DashboardValidationConstant.DELETE);
        assertThat($(DashboardPage.PRINT_BUTTON).getText()).isEqualTo(DashboardValidationConstant.PRINT);
    }

    public static void checkDashboardsTableNotEmpty() {
        log.debug("Validate Dashboard not empty...");
        $$(DashboardPage.WIDGET_LIST).shouldBe(CollectionCondition.sizeGreaterThan(0));
    }

    public static void verifyWidgetPresentsOnDashboard(String widgetName) {
        log.debug(String.format("Verify widget %s present on Dashboard...", widgetName));
        SelenideElement widget = DashboardPage.getWidget(widgetName);
        assertThat(widget).isNotNull();
    }

    public static void validateWidget(String widgetName, String widgetType, String widgetViewType) {
        log.debug(String.format("Validate widget %s...", widgetName));
        SelenideElement widget = DashboardPage.getWidget(widgetName);
        assertThat(widget.$(Widget.WIDGET_TYPE).getText()).isEqualTo(widgetType);
        assertThat(widget.$(Widget.WIDGET_VIEW_TYPE).getText()).isEqualTo(widgetViewType);
    }

    public static void validateDeleteWidgetPopover() {
        log.debug("Check Delete widget popover is opened...");
        SelenideElement popover = $(DashboardPage.DELETE_WIDGET_POPOVER);
        assertThat(popover.$(DeleteWidgetPopover.TITLE).getText()).isEqualTo(DashboardValidationConstant.DELETE_WIDGET_POPOVER_TITLE);
        assertThat(popover.$(DeleteWidgetPopover.CANCEL_BUTTON).getText()).isEqualTo(DashboardValidationConstant.CANCEL);
        assertThat(popover.$(DeleteWidgetPopover.DELETE_BUTTON).getText()).isEqualTo(DashboardValidationConstant.DELETE);
    }
}
