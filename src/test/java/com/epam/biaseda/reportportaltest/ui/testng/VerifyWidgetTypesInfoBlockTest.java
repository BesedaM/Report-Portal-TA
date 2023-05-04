package com.epam.biaseda.reportportaltest.ui.testng;

import com.epam.biaseda.reportportaltest.ui.logic.LoginServiceUILogic;
import com.epam.biaseda.reportportaltest.ui.service.SelectWidgetTypeUIService;
import com.epam.biaseda.reportportaltest.ui.service.DashboardUIService;
import com.epam.biaseda.reportportaltest.ui.service.DashboardsUIService;
import com.epam.biaseda.reportportaltest.ui.testng.dataprovider.CustomDataProvider;
import com.epam.biaseda.reportportaltest.ui.validation.AddNewWidgetLightboxBaseValidation;
import com.epam.biaseda.reportportaltest.ui.validation.DashboardUIValidation;
import com.epam.biaseda.reportportaltest.ui.validation.DashboardsUIValidation;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Widgets")
@Story("[UI] Verify Widget Types info block test")
public class VerifyWidgetTypesInfoBlockTest extends BaseUITest {

    private final String DASHBOARD_TITLE = "DEMO DASHBOARD";


    @Test(description = "login to Report Portal")
    public void login() {
        LoginServiceUILogic.login();
        DashboardsUIValidation.checkDashboardsTableNotEmpty();
    }

    @Test(dependsOnMethods = "login",
            description = "open Dashboards page and validate it")
    public void openDashboardsPage() {
        DashboardsUIService.openDashboard(DASHBOARD_TITLE);
        DashboardUIValidation.checkDashboardsTableNotEmpty();
    }

    @Test(dependsOnMethods = "openDashboardsPage",
            description = "open Add New Widget Lightbox")
    public void openAddNewWidgetLightbox() {
        DashboardUIService.addNewWidget();
        AddNewWidgetLightboxBaseValidation.validateLightboxHeader();
    }

    @Test(dataProvider = "widgetTypes", dataProviderClass = CustomDataProvider.class,
            dependsOnMethods = "openAddNewWidgetLightbox",
            description = "validate widget description for widget types")
    public void validateNewWidgetType(String widgetType, String widgetDescription) {
        SelectWidgetTypeUIService.selectWidgetType(widgetType);
        AddNewWidgetLightboxBaseValidation.validateWidgetInfoBlock(widgetType, widgetDescription);
    }
}
