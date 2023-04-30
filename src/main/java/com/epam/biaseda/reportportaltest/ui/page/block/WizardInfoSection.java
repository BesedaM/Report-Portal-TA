package com.epam.biaseda.reportportaltest.ui.page.block;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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
}
