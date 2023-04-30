package com.epam.biaseda.reportportaltest.ui.validation;

import com.epam.biaseda.reportportaltest.ui.page.addnewlightbox.AddNewWidgetLightbox;
import com.epam.biaseda.reportportaltest.ui.page.block.WizardStep;
import com.epam.biaseda.reportportaltest.ui.validation.constants.AddNewWidgetValidationConstant;

import static org.assertj.core.api.Assertions.assertThat;

public class AddNewWidgetLightboxBaseValidation extends BaseUIValidation {

    public static void validateLightboxHeader() {
        log.debug("Validate add new widget header...");
        StringBuilder descriptionReportBuilder = createDescriptionReportBuilder();
        AddNewWidgetLightbox addNewWidgetLightbox = new AddNewWidgetLightbox();
        assertThat(addNewWidgetLightbox.getHeader().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, addNewWidgetLightbox.getHeader().getName())).isEqualTo(AddNewWidgetValidationConstant.HEADER);
        assertThat(addNewWidgetLightbox.getCloseLightboxButton().isDisplayed())
                .as(String.format(VALIDATE_PRESENCE_PATTERN, addNewWidgetLightbox.getCloseLightboxButton().getName())).isTrue();
        log.debug(descriptionReportBuilder.toString());
    }

    public static void validateWidgetInfoBlock(String expectedType, String expectedDescription) {
        log.debug("Validate widget info block...");
        StringBuilder descriptionReportBuilder = createDescriptionReportBuilder();
        AddNewWidgetLightbox addNewWidgetLightbox = new AddNewWidgetLightbox();
        assertThat(addNewWidgetLightbox.getWizardInfoSection().getPreviewWidgetTitle().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, addNewWidgetLightbox.getWizardInfoSection().getPreviewWidgetTitle().getName()))
                .isEqualTo(expectedType);
        assertThat(addNewWidgetLightbox.getWizardInfoSection().getPreviewWidgetDescription().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, addNewWidgetLightbox.getWizardInfoSection().getPreviewWidgetDescription().getName()))
                .isEqualTo(expectedDescription);
        log.debug(descriptionReportBuilder.toString());
    }

    public static void validateWizardSteps(String stepNumber, String stepName, String status) {
        log.debug("Validate widget wizard steps...");
        StringBuilder descriptionReportBuilder = createDescriptionReportBuilder();
        AddNewWidgetLightbox addNewWidgetLightbox = new AddNewWidgetLightbox();
        WizardStep wizardStep = addNewWidgetLightbox.getWizardInfoSection().getWizardStep(Integer.parseInt(stepNumber));
        assertThat(wizardStep.getStepNumber().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, wizardStep.getStepNumber().getName()))
                .isEqualTo(stepNumber);
        assertThat(wizardStep.getStepName().getText())
                .as(String.format(VALIDATE_TEXT_PATTERN, wizardStep.getStepName().getName()))
                .isEqualToIgnoringCase(stepName);
        assertThat(wizardStep.getStatus())
                .as(String.format(VALIDATE_TEXT_PATTERN, "Wizard Step Status"))
                .isEqualTo(status);
        log.debug(descriptionReportBuilder.toString());
    }
}
