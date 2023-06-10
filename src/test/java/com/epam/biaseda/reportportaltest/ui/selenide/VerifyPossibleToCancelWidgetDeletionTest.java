package com.epam.biaseda.reportportaltest.ui.selenide;

import com.epam.biaseda.reportportaltest.ui.selenide.service.DashboardUIService;
import com.epam.biaseda.reportportaltest.ui.selenide.service.DashboardsUIService;
import com.epam.biaseda.reportportaltest.ui.selenide.validation.DashboardUIValidation;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Widgets")
@Story("[UI] Verify possible to Cancel Widget deletion")
public class VerifyPossibleToCancelWidgetDeletionTest extends BaseSelenideUITest {

    private final String DASHBOARD_TITLE = "DEMO DASHBOARD";
    private final String WIDGET_NAME = "LAUNCH STATISTICS BAR";
    private final String WIDGET_TYPE = "Launch statistics chart";
    private final String WIDGET_VIEW_TYPE = "Bar view";

    @Test(description = "open Dashboards page and validate it")
    public void openDashboardsPage() {
        DashboardsUIService.openDashboard(DASHBOARD_TITLE);
        DashboardUIValidation.validateDashboardPageHeader(DASHBOARD_TITLE);
        DashboardUIValidation.checkDashboardsTableNotEmpty();
    }

    @Test(dependsOnMethods = "openDashboardsPage",
            description = "check expected Widget present")
    public void validateWidget() {
        DashboardUIValidation.validateWidget(WIDGET_NAME, WIDGET_TYPE, WIDGET_VIEW_TYPE);
    }

    @Test(dependsOnMethods = "validateWidget",
            description = "click on delete Widget button and validate popover")
    public void validateDeleteWidgetPopover() {
        DashboardUIService.clickOnWidgetDeleteButton(WIDGET_NAME);
        DashboardUIValidation.validateDeleteWidgetPopover();
    }

    @Test(dependsOnMethods = "validateDeleteWidgetPopover",
            description = "cancel Widget deletion and check it is not deleted")
    public void cancelWidgetDeletion() {
        DashboardUIService.cancelWidgetDeletion();
        DashboardUIValidation.validateWidget(WIDGET_NAME, WIDGET_TYPE, WIDGET_VIEW_TYPE);
    }
}
