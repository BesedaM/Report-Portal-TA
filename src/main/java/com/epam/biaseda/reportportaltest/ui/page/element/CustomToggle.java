package com.epam.biaseda.reportportaltest.ui.page.element;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import javax.swing.text.html.HTML;
import java.util.List;
import java.util.NoSuchElementException;

@Getter
public class CustomToggle extends CustomElement {

    @FindBy(xpath = "./div")
    private List<CustomElement> toggleElementList;

    public CustomElement getActiveElement() {
        return toggleElementList.stream().filter(customElement -> customElement.getAttribute(HTML.Attribute.CLASS.toString())
                .contains("active")).findFirst().orElseThrow(() -> new NoSuchElementException("No toggle element is selected state!"));
    }
}
