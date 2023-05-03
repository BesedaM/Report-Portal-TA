package com.epam.biaseda.reportportaltest.ui.page.element;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import javax.swing.text.html.HTML;
import java.util.List;

@Getter
public class CustomRadioButton extends CustomElement {

    @FindBy(xpath = ".//span[contains(@class, 'toggler')]")
    private CustomElement toggler;

    @FindBy(xpath = ".//span[contains(@class, 'children-container')]/*")
    private List<CustomElement> descriptionElements;

    public boolean isChecked(){
        return toggler.getAttribute(HTML.Attribute.CLASS.toString()).contains("checked");
    }
}
