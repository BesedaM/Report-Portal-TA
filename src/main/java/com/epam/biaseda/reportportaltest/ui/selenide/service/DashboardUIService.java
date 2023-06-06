package com.epam.biaseda.reportportaltest.ui.selenide.service;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.epam.biaseda.reportportaltest.ui.selenide.page.DashboardPage;
import com.epam.biaseda.reportportaltest.ui.selenide.page.block.DeleteWidgetPopover;
import com.epam.biaseda.reportportaltest.ui.selenide.page.block.Widget;

import static com.codeborne.selenide.Selenide.$;

public class DashboardUIService {

    public static void clickOnWidgetDeleteButton(String widgetName) {
        SelenideElement widget = DashboardPage.getWidget(widgetName);
        clickOnDeleteWidgetButton(widget);
        $(DashboardPage.DELETE_WIDGET_POPOVER).$(DeleteWidgetPopover.TITLE).shouldBe(Condition.visible);
    }

    public static void cancelWidgetDeletion() {
        SelenideElement popover = $(DashboardPage.DELETE_WIDGET_POPOVER);
        popover.$(DeleteWidgetPopover.CANCEL_BUTTON).click();
        popover.should(Condition.disappear);
    }

    public static void clickOnDeleteWidgetButton(SelenideElement widget) {
        widget.hover();
        SelenideElement deleteButton = widget.$(Widget.DELETE_BUTTON);
        deleteButton.shouldBe(Condition.interactable).click();
    }
}
