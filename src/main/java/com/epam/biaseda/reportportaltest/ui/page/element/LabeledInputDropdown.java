package com.epam.biaseda.reportportaltest.ui.page.element;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class LabeledInputDropdown extends CustomElement {

    @FindBy(xpath = "./div/span")
    private CustomElement label;

    @FindBy(xpath = ".//div[contains(@class,'dropdown-container')]/div")
    private CustomElement selectedValues;

    @FindBy(xpath = ".//div[contains(@class,'select-list')]")
    private InputDropdownSelectList inputDropdownSelectList;
}
