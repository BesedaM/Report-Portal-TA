package com.epam.biaseda.reportportaltest.ui.service;

import com.epam.biaseda.reportportaltest.ui.driver.action.WaitAction;
import com.epam.biaseda.reportportaltest.ui.page.DashboardPage;
import com.epam.biaseda.reportportaltest.ui.page.addnewlightbox.SelectWidgetTypeLightbox;
import com.epam.biaseda.reportportaltest.ui.page.block.Widget;

public class DashboardUIService {

    public static void clickOnWidgetDeleteButton(String widgetName) {
        Widget widget = new DashboardPage().getWidget(widgetName);
        WidgetUIService.clickOnDeleteButton(widget);
        WaitAction.getWebDriverWait()
                .withMessage("No Delete Widget Popover opened!")
                .until(driver -> new DashboardPage().getDeleteWidgetPopover().getTitle().isDisplayed());
    }

    public static void cancelWidgetDeletion() {
        new DashboardPage().getDeleteWidgetPopover().getCancelButton().click();
        WaitAction.waitUntilInvisible(new DashboardPage().getDeleteWidgetPopover());
    }

    public static void confirmWidgetDeletion() {
        new DashboardPage().getDeleteWidgetPopover().getDeleteButton().click();
        WaitAction.waitUntilInvisible(new DashboardPage().getDeleteWidgetPopover());
    }

    public static void addNewWidget() {
        new DashboardPage().getAddNewWidgetButton().click();
        new SelectWidgetTypeLightbox().waitForPageLoaded();
    }
}
