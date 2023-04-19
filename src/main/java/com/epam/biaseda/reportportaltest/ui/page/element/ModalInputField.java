package com.epam.biaseda.reportportaltest.ui.page.element;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class ModalInputField extends CustomElement{

    @FindBy(xpath = ".//div[contains(@class, 'label')]")
    private CustomElement label;

    @FindBy(xpath = ".//*[contains(@class, 'text')]")
    private CustomElement textInput;

    @FindBy(xpath = "//div[contains(@class, 'wizardControlsSection')]/button[1]")
    private CustomElement previousStepButton;

    @FindBy(xpath = "//div[contains(@class, 'wizardControlsSection')]/button[2]")
    private CustomElement addButton;
}
