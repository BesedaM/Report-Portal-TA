package com.epam.biaseda.reportportaltest.ui.service;

import com.epam.biaseda.reportportaltest.ui.driver.action.WaitAction;
import com.epam.biaseda.reportportaltest.ui.page.addnewlightbox.ProjectActivityPanelWidgetLightbox;

public class ProjectActivityPanelUIService extends BasicConfigureWidgetUIService {

    public static void openCriteriaForWidgetDropdown() {
        new ProjectActivityPanelWidgetLightbox().getProjectActivityPanelSettings()
                .getCriteriaForWidget().getSelectedValues().click();
        WaitAction.waitUntilVisible(new ProjectActivityPanelWidgetLightbox().getProjectActivityPanelSettings()
                .getCriteriaForWidget().getInputDropdownSelectList().getSelectAll());
    }
}
