package com.epam.biaseda.reportportaltest.ui.service;

import com.epam.biaseda.reportportaltest.ui.driver.action.WaitAction;
import com.epam.biaseda.reportportaltest.ui.page.addnewlightbox.LaunchStatisticsChartWidgetLightbox;
import com.epam.biaseda.reportportaltest.ui.page.element.CustomRadioButton;

import java.util.List;

public class LaunchStatisticsChartUIService extends BasicConfigureWidgetUIService {

    public static void selectFilter(String filterName) {
        List<CustomRadioButton> filterList = new LaunchStatisticsChartWidgetLightbox()
                .getAddWidgetFilterSettings()
                .getFilterList();
        selectFilter(filterList, filterName);
    }

    public static void openCriteriaForWidgetDropdown() {
        new LaunchStatisticsChartWidgetLightbox().getLaunchStatisticsChartSettings()
                .getCriteriaForWidget().getSelectedValues().click();
        WaitAction.waitUntilVisible(new LaunchStatisticsChartWidgetLightbox().getLaunchStatisticsChartSettings()
                .getCriteriaForWidget().getInputDropdownSelectList().getSelectAll());
    }

    public static void goToNextStep() {
        goToNextStep(new LaunchStatisticsChartWidgetLightbox().getNextStepButton());
    }
}
