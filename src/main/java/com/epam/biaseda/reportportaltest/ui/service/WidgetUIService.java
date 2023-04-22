package com.epam.biaseda.reportportaltest.ui.service;

import com.epam.biaseda.reportportaltest.ui.driver.action.EventAction;
import com.epam.biaseda.reportportaltest.ui.driver.action.WaitAction;
import com.epam.biaseda.reportportaltest.ui.page.block.Widget;
import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;

public class WidgetUIService {

    public static void clickOnDeleteButton(Widget widget) {
        CustomElement deleteButton = widget.getDeleteButton();
        EventAction.mouseOver(widget);
        WaitAction.waitUntilClickable(deleteButton);
        deleteButton.click();
    }
}
