package com.epam.biaseda.reportportaltest.ui;

import com.epam.biaseda.reportportaltest.ui.logic.LoginServiceUILogic;
import com.epam.biaseda.reportportaltest.ui.service.DashboardUIService;
import com.epam.biaseda.reportportaltest.ui.service.DashboardsUIService;
import com.epam.biaseda.reportportaltest.ui.validation.DashboardUIValidation;
import com.epam.biaseda.reportportaltest.ui.validation.DashboardsUIValidation;
import org.testng.annotations.Test;

public class VerifyPossibleToCancelWidgetDeletionTest extends BaseUITest {

    private final String DASHBOARD_TITLE = "DEMO DASHBOARD";
    private final String WIDGET_NAME = "LAUNCH STATISTICS BAR";
    private final String WIDGET_TYPE = "Launch statistics chart";
    private final String WIDGET_VIEW_TYPE = "Bar view";

    @Test
    public void login() {
        LoginServiceUILogic.login();
        DashboardsUIValidation.validateDashboardsPageHeader();
        DashboardsUIValidation.validateDashboardsTableViewHeader();
        DashboardsUIValidation.checkDashboardsTableNotEmpty();
    }

    @Test(dependsOnMethods = "login")
    public void openDashboardsPage() {
        DashboardsUIService.openDashboard(DASHBOARD_TITLE);
        DashboardUIValidation.validateDashboardPageHeader(DASHBOARD_TITLE);
        DashboardUIValidation.checkDashboardsTableNotEmpty();
    }

    @Test(dependsOnMethods = "openDashboardsPage")
    public void validateWidget() {

        DashboardUIValidation.validateWidget(WIDGET_NAME, WIDGET_TYPE, WIDGET_VIEW_TYPE);
    }

    @Test(dependsOnMethods = "validateWidget")
    public void validateDeleteWidgetPopover() {
        DashboardUIValidation.validateWidget(WIDGET_NAME, WIDGET_TYPE, WIDGET_VIEW_TYPE);
        DashboardUIService.clickOnWidgetDeleteButton(WIDGET_NAME);
    }

    @Test(dependsOnMethods = "validateDeleteWidgetPopover")
    public void cancelWidgetDeletion() {
        DashboardUIValidation.validateDeleteWidgetPopover();
        DashboardUIService.cancelWidgetDeletion();
        DashboardUIValidation.validateWidget(WIDGET_NAME, WIDGET_TYPE, WIDGET_VIEW_TYPE);
    }
}
