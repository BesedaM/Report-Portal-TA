package com.epam.biaseda.reportportaltest.ui.page.block;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import javax.swing.text.html.HTML;

@Getter
public class WizardStep extends CustomElement {

    @FindBy(xpath = "./div[contains(@class, 'number')]")
    private CustomElement stepNumber;

    @FindBy(xpath = "./div[contains(@class, 'label')]")
    private CustomElement stepName;

    public boolean isCompleted(){
        return this.getAttribute(HTML.Attribute.CLASS.toString()).contains("completed");
    }

    public boolean isActive(){
        return this.getAttribute(HTML.Attribute.CLASS.toString()).contains("active");
    }
}
