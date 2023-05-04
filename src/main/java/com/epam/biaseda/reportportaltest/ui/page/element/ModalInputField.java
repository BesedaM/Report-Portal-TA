package com.epam.biaseda.reportportaltest.ui.page.element;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class ModalInputField extends CustomElement{

    @FindBy(xpath = ".//span")
    private CustomElement label;

    @FindBy(xpath = ".//input | .//textarea")
    private CustomElement textInput;

}
