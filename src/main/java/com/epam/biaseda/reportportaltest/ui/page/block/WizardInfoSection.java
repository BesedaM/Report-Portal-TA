package com.epam.biaseda.reportportaltest.ui.page.block;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

@Getter
public class WizardInfoSection extends CustomElement {

    @FindBy(xpath = ".//div[contains(@class, 'step-label-item')]")
    private List<WizardStep> wizardStepElement;

    @FindBy(xpath = ".//div[contains(@class,'widget-title')]")
    private CustomElement previewWidgetTitle;

    @FindBy(xpath = ".//div[contains(@class,'widget-description')]")
    private CustomElement previewWidgetDescription;

    @FindBy(xpath = ".//div[contains(@class,'widget-preview')]")
    private CustomElement previewWidgetImage;

    public WizardStep getWizardStep(int number) {
        return wizardStepElement.get(number - 1);
    }

    public WizardStep getWizardStep(String name) {
        return wizardStepElement.stream().filter(wizardStep-> wizardStep.getStepName().getText().equals(name)).findFirst()
                .orElseThrow(()-> new NoSuchElementException(String.format("Unknown wizard step '%s' name!", name)));
    }
}
