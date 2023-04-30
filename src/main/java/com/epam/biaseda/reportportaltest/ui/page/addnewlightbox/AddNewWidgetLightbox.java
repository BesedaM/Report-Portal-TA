package com.epam.biaseda.reportportaltest.ui.page.addnewlightbox;

import com.epam.biaseda.reportportaltest.ui.page.BasePage;
import com.epam.biaseda.reportportaltest.ui.page.block.WizardInfoSection;
import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class AddNewWidgetLightbox extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'modal-header-content')]")
    private CustomElement header;

    @FindBy(xpath = "//div[contains(@class, 'close-modal-icon')]")
    private CustomElement closeLightboxButton;

    @FindBy(xpath = "//div[contains(@class,'wizard-info-section')]")
    private WizardInfoSection wizardInfoSection;
}
