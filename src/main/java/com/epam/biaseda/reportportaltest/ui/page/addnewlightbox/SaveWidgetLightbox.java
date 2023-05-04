package com.epam.biaseda.reportportaltest.ui.page.addnewlightbox;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import com.epam.biaseda.reportportaltest.ui.page.element.ModalInputField;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class SaveWidgetLightbox extends AddNewWidgetLightbox {

    @FindBy(xpath = "//div[contains(@class, 'modal-field--')][1]")
    private ModalInputField widgetName;

    @FindBy(xpath = "//div[contains(@class, 'modal-field--')][2]")
    private ModalInputField widgetDescription;

    //TODO add missing elements


    @FindBy(xpath = "//div[contains(@class, 'wizardControlsSection')]/button[1]")
    private CustomElement previousStepButton;

    @FindBy(xpath = "//div[contains(@class, 'wizardControlsSection')]/button[2]")
    private CustomElement addButton;
}
