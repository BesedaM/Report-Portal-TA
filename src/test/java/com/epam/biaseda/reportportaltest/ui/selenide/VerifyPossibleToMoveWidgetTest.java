package com.epam.biaseda.reportportaltest.ui.selenide;

import com.epam.biaseda.reportportaltest.ui.selenide.service.DashboardUIService;
import com.epam.biaseda.reportportaltest.ui.selenide.service.DashboardsUIService;
import com.epam.biaseda.reportportaltest.ui.selenide.validation.DashboardUIValidation;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.Point;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Feature("Widgets")
@Story("[UI] Verify possible to Resize Widget")
public class VerifyPossibleToMoveWidgetTest extends BaseSelenideUITest {

    private final String DASHBOARD_TITLE = "123";
    private final String WIDGET_NAME = "DEMO_FILTER_426";
    private final String OTHER_WIDGET_NAME = "DEMO_FILTER_085";

    private Point widgetLocation;
    private Point otherWidgetLocation;

    @Test(description = "open Dashboards page and validate it")
    public void openDashboardsPage() {
        DashboardsUIService.openDashboard(DASHBOARD_TITLE);
        DashboardUIValidation.validateDashboardPageHeader(DASHBOARD_TITLE);
        DashboardUIValidation.checkDashboardsTableNotEmpty();
    }

    @Test(dependsOnMethods = "openDashboardsPage",
            description = "check expected Widgets present")
    public void validateWidgets() {
        DashboardUIValidation.verifyWidgetPresentsOnDashboard(WIDGET_NAME);
        DashboardUIValidation.verifyWidgetPresentsOnDashboard(OTHER_WIDGET_NAME);
    }

    @Test(dependsOnMethods = "validateWidgets",
            description = "save current elements locations")
    public void saveCurrentElementsInfo() {
        widgetLocation = DashboardUIService.getWidgetLocation(WIDGET_NAME);
        otherWidgetLocation = DashboardUIService.getWidgetLocation(OTHER_WIDGET_NAME);
    }

    @Test(dependsOnMethods = "saveCurrentElementsInfo",
            description = "resize widget")
    public void dragAndDropWidget() {
        DashboardUIService.moveToWidget(WIDGET_NAME);
        DashboardUIService.replaceWidgets(WIDGET_NAME, OTHER_WIDGET_NAME);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(DashboardUIService.getWidgetLocation(WIDGET_NAME), widgetLocation, "Main Widget Location hasn't changed!");
        softAssert.assertNotEquals(DashboardUIService.getWidgetLocation(OTHER_WIDGET_NAME), otherWidgetLocation, "Other widget Location hasn't changed!");
        softAssert.assertAll();
    }

    @AfterClass(alwaysRun = true)
    public void moveWidgetBack() {
        DashboardUIService.moveToWidget(OTHER_WIDGET_NAME);
        DashboardUIService.replaceWidgets(OTHER_WIDGET_NAME, WIDGET_NAME);
    }
}
