package com.epam.biaseda.reportportaltest.ui.selenide;

import com.epam.biaseda.reportportaltest.ui.selenide.service.DashboardUIService;
import com.epam.biaseda.reportportaltest.ui.selenide.service.DashboardsUIService;
import com.epam.biaseda.reportportaltest.ui.selenide.validation.DashboardUIValidation;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Feature("Widgets")
@Story("[UI] Verify possible to Resize Widget")
public class VerifyPossibleToResizeWidgetTest extends BaseSelenideUITest {

    private final String DASHBOARD_TITLE = "123";
    private final String WIDGET_NAME = "LAUNCH STATISTICS BAR";
    private final String OTHER_WIDGET_NAME = "DEMO_FILTER_426";

    private static final int X_OFFSET = 250;
    private static final int Y_OFFSET = 100;

    private Dimension widgetDimension;
    private Point otherWidgetLocation;
    private Point deleteButtonLocation;

    @Test(description = "open Dashboards page and validate it")
    public void openDashboardsPage() {
        DashboardsUIService.openDashboard(DASHBOARD_TITLE);
        DashboardUIValidation.validateDashboardPageHeader(DASHBOARD_TITLE);
        DashboardUIValidation.checkDashboardsTableNotEmpty();
    }

    @Test(dependsOnMethods = "openDashboardsPage",
            description = "check expected Widget present")
    public void validateWidget() {
        DashboardUIValidation.verifyWidgetPresentsOnDashboard(WIDGET_NAME);
    }

    @Test(dependsOnMethods = "validateWidget",
            description = "save current elements locations")
    public void saveCurrentElementsInfo() {
        widgetDimension = DashboardUIService.getWidgetSize(WIDGET_NAME);
        otherWidgetLocation = DashboardUIService.getWidgetLocation(OTHER_WIDGET_NAME);
        deleteButtonLocation = DashboardUIService.getWidgetDeleteButtonLocation(WIDGET_NAME);
    }

    @Test(dependsOnMethods = "saveCurrentElementsInfo",
            description = "resize widget")
    public void resizeWidget() {
        DashboardUIService.resizeWidget(WIDGET_NAME, X_OFFSET, Y_OFFSET);
    }

    @Test(dependsOnMethods = "resizeWidget",
            description = "cancel Widget deletion and check it is not deleted")
    public void verifyResize() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(DashboardUIService.getWidgetSize(WIDGET_NAME), widgetDimension, "Widget Size wasn't changed!");
        softAssert.assertNotEquals(DashboardUIService.getWidgetLocation(OTHER_WIDGET_NAME), otherWidgetLocation, "Other widget Location wasn't changed!");
        softAssert.assertNotEquals(DashboardUIService.getWidgetDeleteButtonLocation(WIDGET_NAME), deleteButtonLocation, "Delete button Location wasn't changed!");
        softAssert.assertAll();
    }

    @AfterClass(alwaysRun = true)
    public void resizeWidgetBack() {
        DashboardUIService.resizeWidget(WIDGET_NAME, -X_OFFSET, -Y_OFFSET);
    }
}
