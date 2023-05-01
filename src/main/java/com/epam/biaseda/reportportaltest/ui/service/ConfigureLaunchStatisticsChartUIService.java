package com.epam.biaseda.reportportaltest.ui.service;

import com.epam.biaseda.reportportaltest.ui.driver.action.WaitAction;
import com.epam.biaseda.reportportaltest.ui.page.addnewlightbox.ConfigureLaunchStatisticsChartWidgetLightbox;
import com.epam.biaseda.reportportaltest.ui.page.addnewlightbox.SaveWidgetLightbox;
import com.epam.biaseda.reportportaltest.ui.page.element.CustomRadioButton;

import java.util.List;
import java.util.NoSuchElementException;

public class ConfigureLaunchStatisticsChartUIService {

    private static final String THIRD_WIZARD_STEP = "SAVE";

    public static void selectFilter(String filterName) {
        List<CustomRadioButton> filterList = new ConfigureLaunchStatisticsChartWidgetLightbox()
                .getAddWidgetFilterSettings()
                .getFilterList();
        CustomRadioButton filterToSelect = filterList.stream()
                .filter(filter -> filter.getDescriptionElements().get(0).getText().equals(filterName))
                .findFirst().orElseThrow(() -> new NoSuchElementException(String.format("Unknown filter '%s'!", filterName)));
        filterToSelect.click();
    }

    public static void goToNextStep() {
        new ConfigureLaunchStatisticsChartWidgetLightbox().getNextStepButton().click();
        WaitAction.getWebDriverWait()
                .withMessage("Unable to get to next step with wizard!")
                .until(driver -> new SaveWidgetLightbox().getWizardInfoSection().getWizardStep(THIRD_WIZARD_STEP).isActive());
    }
}
