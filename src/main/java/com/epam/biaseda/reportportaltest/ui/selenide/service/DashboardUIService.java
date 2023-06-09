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

import static com.codeborne.selenide.Selenide.$;

public class DashboardUIService {

    private static final CustomLogger log = CustomLoggerProvider.getLogger();

    public static void clickOnWidgetDeleteButton(String widgetName) {
        SelenideElement widget = DashboardPage.getWidget(widgetName);
        clickOnDeleteWidgetButton(widget);
        WaitAction.waitUntilVisible($(DashboardPage.DELETE_WIDGET_POPOVER).$(DeleteWidgetPopover.TITLE));
    }

    public static void cancelWidgetDeletion() {
        SelenideElement popover = $(DashboardPage.DELETE_WIDGET_POPOVER);
        popover.$(DeleteWidgetPopover.CANCEL_BUTTON).click();
        WaitAction.waitUntilInvisible(popover);
    }

    public static void clickOnDeleteWidgetButton(SelenideElement widget) {
        widget.hover();
        SelenideElement deleteButton = widget.$(Widget.DELETE_BUTTON);
        WaitAction.waitUntilClickable(deleteButton);
        deleteButton.click();
    }

    public static void resizeWidget(String widgetName, int xOffset, int yOffset) {
        SelenideElement widget = DashboardPage.getWidget(widgetName);
        EventAction.resize(widget.$(Widget.RESIZABLE_HANDLE), xOffset, yOffset);
        WaitAction.waitUntilAnimationComplete(widget);
    }

    public static void moveToWidget(String widgetName) {
        SelenideElement widget = DashboardPage.getWidget(widgetName);
        EventAction.scrollIntoView(widget);
        WaitAction.waitUntilScrolledIntoView(widget);
    }

    public static void replaceWidgets(String sourceWidgetName, String targetWidgetName) {
        SelenideElement sourceWidgetHeader = DashboardPage.getWidget(sourceWidgetName).$(Widget.WIDGET_HEADER);
        SelenideElement targetWidget = DashboardPage.getWidget(targetWidgetName);
        EventAction.dragAndDrop(sourceWidgetHeader, targetWidget);
        WaitAction.waitUntilAnimationComplete(sourceWidgetHeader);
    }

    public static Point getWidgetLocation(String widgetName) {
        Point location = DashboardPage.getWidget(widgetName).getLocation();
        log.info(String.format("Widget '%s' location is '%s'", widgetName, location));
        return location;
    }

    public static Dimension getWidgetSize(String widgetName) {
        Dimension size = DashboardPage.getWidget(widgetName).getSize();
        log.info(String.format("Widget '%s' size is '%s'", widgetName, size));
        return size;
    }

    public static Point getWidgetDeleteButtonLocation(String widgetName) {
        Point location = DashboardPage.getWidget(widgetName).$(Widget.DELETE_BUTTON).getLocation();
        log.info(String.format("Widget '%s' Delete button location is '%s'", widgetName, location));
        return location;
    }
}
