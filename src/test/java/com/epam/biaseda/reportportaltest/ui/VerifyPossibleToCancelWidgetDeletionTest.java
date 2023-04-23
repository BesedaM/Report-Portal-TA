package com.epam.biaseda.reportportaltest.ui;

import com.epam.biaseda.reportportaltest.ui.listener.TestExecutionListener;
import com.epam.biaseda.reportportaltest.ui.logic.LoginServiceUILogic;
import com.epam.biaseda.reportportaltest.ui.service.DashboardUIService;
import com.epam.biaseda.reportportaltest.ui.service.DashboardsUIService;
import com.epam.biaseda.reportportaltest.ui.validation.DashboardUIValidation;
import com.epam.biaseda.reportportaltest.ui.validation.DashboardsUIValidation;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestExecutionListener.class})
@Feature("Widgets")
@Story("[UI] Verify possible to Cancel Widget deletion")
public class VerifyPossibleToCancelWidgetDeletionTest extends BaseUITest {

    private final String DASHBOARD_TITLE = "DEMO DASHBOARD";
    private final String WIDGET_NAME = "LAUNCH STATISTICS BAR";
    private final String WIDGET_TYPE = "Launch statistics chart";
    private final String WIDGET_VIEW_TYPE = "Bar view";

    @Test(description = "login to Report Portal")
    public void login() {
        LoginServiceUILogic.login();
        DashboardsUIValidation.validateDashboardsPageHeader();
        DashboardsUIValidation.validateDashboardsTableViewHeader();
        DashboardsUIValidation.checkDashboardsTableNotEmpty();
    }

    @Test(dependsOnMethods = "login",
            description = "open Dashboards page and validate it")
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
        DashboardUIValidation.validateWidget(WIDGET_NAME, WIDGET_TYPE, WIDGET_VIEW_TYPE);
        DashboardUIService.clickOnWidgetDeleteButton(WIDGET_NAME);
    }

    @Test(dependsOnMethods = "validateDeleteWidgetPopover",
            description = "cancel Widget deletion and check it is not deleted")
    public void cancelWidgetDeletion() {
        DashboardUIValidation.validateDeleteWidgetPopover();
        DashboardUIService.cancelWidgetDeletion();
        DashboardUIValidation.validateWidget(WIDGET_NAME, WIDGET_TYPE, WIDGET_VIEW_TYPE);
    }
}
