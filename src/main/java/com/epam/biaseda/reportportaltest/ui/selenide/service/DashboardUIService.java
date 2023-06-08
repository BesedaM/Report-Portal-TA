package com.epam.biaseda.reportportaltest.ui.selenide.service;

import com.codeborne.selenide.SelenideElement;
import com.epam.biaseda.reportportaltest.ui.selenide.page.DashboardPage;
import com.epam.biaseda.reportportaltest.ui.selenide.page.block.DeleteWidgetPopover;
import com.epam.biaseda.reportportaltest.ui.selenide.page.block.Widget;
import com.epam.biaseda.reportportaltest.ui.selenide.service.action.WaitAction;

import static com.codeborne.selenide.Selenide.$;

public class DashboardUIService {

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
}