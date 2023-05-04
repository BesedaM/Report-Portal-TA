package com.epam.biaseda.reportportaltest.ui.page.block;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

import javax.swing.text.html.HTML;

@Getter
public class WizardStep extends CustomElement {

    private static final String COMPLETED = "completed";
    private static final String ACTIVE = "active";
    private static final String NOT_STARTED = "not started";

    @Name("Step number")
    @FindBy(xpath = "./div[contains(@class, 'number')]")
    private CustomElement stepNumber;

    @Name("Step name")
    @FindBy(xpath = "./div[contains(@class, 'label')]")
    private CustomElement stepName;

    public String getStatus() {
        String classAttribute = this.getAttribute(HTML.Attribute.CLASS.toString());
        if (classAttribute.contains(COMPLETED)) {
            return COMPLETED;
        } else if (classAttribute.contains(ACTIVE)) {
            return ACTIVE;
        }
        return NOT_STARTED;
    }

    public boolean isActive() {
        return this.getAttribute(HTML.Attribute.CLASS.toString()).contains("active");
    }
}
