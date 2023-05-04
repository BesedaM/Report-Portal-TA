package com.epam.biaseda.reportportaltest.ui.page.element;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class InputDropdownSelectList extends CustomElement {

    @FindBy(xpath = ".//div[contains(@class,'select-all-block')]")
    private CustomElement selectAll;

    @FindBy(xpath=".//div[contains(@class,'dropdown-option')]")
    private List<CustomElement> optionList;
}
