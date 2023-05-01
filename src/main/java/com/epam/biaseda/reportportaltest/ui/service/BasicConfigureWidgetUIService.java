package com.epam.biaseda.reportportaltest.ui.service;

import com.epam.biaseda.reportportaltest.ui.driver.action.WaitAction;
import com.epam.biaseda.reportportaltest.ui.page.addnewlightbox.SaveWidgetLightbox;
import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import com.epam.biaseda.reportportaltest.ui.page.element.CustomRadioButton;

import java.util.List;
import java.util.NoSuchElementException;

public class BasicConfigureWidgetUIService {

    private static final String THIRD_WIZARD_STEP = "SAVE";

    protected static void selectFilter(List<CustomRadioButton> filterList, String filterName) {
        CustomRadioButton filterToSelect = filterList.stream()
                .filter(filter -> filter.getDescriptionElements().get(0).getText().equals(filterName))
                .findFirst().orElseThrow(() -> new NoSuchElementException(String.format("Unknown filter '%s'!", filterName)));
        filterToSelect.click();
    }

    protected static void goToNextStep(CustomElement nextStepButton) {
        nextStepButton.click();
        WaitAction.getWebDriverWait()
                .withMessage("Unable to get to next step with wizard!")
                .until(driver -> new SaveWidgetLightbox().getWizardInfoSection().getWizardStep(THIRD_WIZARD_STEP).isActive());
    }
}
