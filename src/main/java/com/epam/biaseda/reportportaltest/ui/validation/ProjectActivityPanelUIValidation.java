package com.epam.biaseda.reportportaltest.ui.validation;

import com.epam.biaseda.reportportaltest.ui.page.addnewlightbox.ProjectActivityPanelWidgetLightbox;
import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;

import java.util.List;

public class ProjectActivityPanelUIValidation extends BaseWidgetConfigureValidation {

    public static void verifyCriteriaForWidgetDropdownMenu(String menuName) {
        List<CustomElement> dropdownOptions = new ProjectActivityPanelWidgetLightbox().getProjectActivityPanelSettings()
                .getCriteriaForWidget().getInputDropdownSelectList().getOptionList();
        verifyCriteriaForWidgetDropdownMenu(dropdownOptions, menuName);
    }
}
