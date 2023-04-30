package com.epam.biaseda.reportportaltest.ui.service;

import com.epam.biaseda.reportportaltest.ui.driver.action.WaitAction;
import com.epam.biaseda.reportportaltest.ui.page.addnewlightbox.ConfigureWidgetLightbox;
import com.epam.biaseda.reportportaltest.ui.page.addnewlightbox.SelectWidgetTypeLightbox;
import com.epam.biaseda.reportportaltest.ui.page.element.CustomRadioButton;

public class SelectWidgetTypeUIService {

    private static final String SECOND_WIZARD_STEP = "Configure widget";

    public static void selectWidgetType(String widgetType) {
        CustomRadioButton widgetButton = new SelectWidgetTypeLightbox().getWidget(widgetType);
        widgetButton.click();
        WaitAction.getWebDriverWait()
                .withMessage(String.format("Widget '%s' was not selected!", widgetType))
                .until(driver -> widgetButton.isChecked());
    }

    public static void goToNextStep(){
        new SelectWidgetTypeLightbox().getNextStepButton().click();
        WaitAction.getWebDriverWait()
                .withMessage("Unable to get to next step with wizard!")
                .until(driver-> new ConfigureWidgetLightbox().getWizardInfoSection().getWizardStep(SECOND_WIZARD_STEP).isActive());
    }
}
