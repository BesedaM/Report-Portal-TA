package com.epam.biaseda.reportportaltest.ui.validation;

import com.epam.biaseda.reportportaltest.ui.page.addnewlightbox.LaunchStatisticsChartWidgetLightbox;
import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;

import java.util.List;

public class LaunchStatisticsChartUIValidation extends BaseWidgetConfigureValidation {

    public static void verifyCriteriaForWidgetDropdownMenu(String menuName) {
        List<CustomElement> dropdownOptions = new LaunchStatisticsChartWidgetLightbox().getLaunchStatisticsChartSettings()
                .getCriteriaForWidget().getInputDropdownSelectList().getOptionList();
        verifyCriteriaForWidgetDropdownMenu(dropdownOptions, menuName);
    }
}
