package com.epam.biaseda.reportportaltest.ui.selenide.service;

import com.codeborne.selenide.SelenideElement;
import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.ui.selenide.page.DashboardPage;
import com.epam.biaseda.reportportaltest.ui.selenide.page.block.DeleteWidgetPopover;
import com.epam.biaseda.reportportaltest.ui.selenide.page.block.Widget;
import com.epam.biaseda.reportportaltest.ui.selenide.service.action.EventAction;
import com.epam.biaseda.reportportaltest.ui.selenide.service.action.WaitAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import static com.codeborne.selenide.Selenide.page;

public class DashboardUIService {

    private static final CustomLogger log = CustomLoggerProvider.getLogger();

    private static DashboardPage dashboardPage = page(new DashboardPage());

    public static void clickOnWidgetDeleteButton(String widgetName) {
        Widget widget = dashboardPage.getWidget(widgetName);
        clickOnDeleteWidgetButton(widget);
        WaitAction.waitUntilVisible(dashboardPage.getDeleteWidgetPopover().getTitle());
    }

    public static void cancelWidgetDeletion() {
        DeleteWidgetPopover popover = dashboardPage.getDeleteWidgetPopover();
        popover.getCancelButton().click();
        WaitAction.waitUntilInvisible(popover.getElement());
    }

    public static void clickOnDeleteWidgetButton(Widget widget) {
        widget.getElement().hover();
        SelenideElement deleteButton = widget.getDeleteButton();
        WaitAction.waitUntilClickable(deleteButton);
        deleteButton.click();
    }

    public static void resizeWidget(String widgetName, int xOffset, int yOffset) {
        Widget widget = dashboardPage.getWidget(widgetName);
        EventAction.resize(widget.getResizableHandle(), xOffset, yOffset);
        WaitAction.waitUntilAnimationComplete(widget.getElement());
    }

    public static void moveToWidget(String widgetName) {
        Widget widget = dashboardPage.getWidget(widgetName);
        EventAction.scrollIntoView(widget.getElement());
        WaitAction.waitUntilScrolledIntoView(widget.getElement());
    }

    public static void replaceWidgets(String sourceWidgetName, String targetWidgetName) {
        SelenideElement sourceWidgetHeader = dashboardPage.getWidget(sourceWidgetName).getHeader();
        SelenideElement targetWidget = dashboardPage.getWidget(targetWidgetName).getElement();
        EventAction.dragAndDrop(sourceWidgetHeader, targetWidget);
        WaitAction.waitUntilAnimationComplete(sourceWidgetHeader);
    }

    public static Point getWidgetLocation(String widgetName) {
        Point location = dashboardPage.getWidget(widgetName).getElement().getLocation();
        log.info(String.format("Widget '%s' location is '%s'", widgetName, location));
        return location;
    }

    public static Dimension getWidgetSize(String widgetName) {
        Dimension size = dashboardPage.getWidget(widgetName).getElement().getSize();
        log.info(String.format("Widget '%s' size is '%s'", widgetName, size));
        return size;
    }

    public static Point getWidgetDeleteButtonLocation(String widgetName) {
        Point location = dashboardPage.getWidget(widgetName).getDeleteButton().getLocation();
        log.info(String.format("Widget '%s' Delete button location is '%s'", widgetName, location));
        return location;
    }
}
