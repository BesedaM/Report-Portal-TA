package com.epam.biaseda.reportportaltest.ui.page.block;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class SharedWidgetListItem extends CustomElement {

    @FindBy(xpath = ".//span[contains(@class, 'name')]")
    private CustomElement widgetName;

    @FindBy(xpath = ".//span[contains(@class, 'type')]")
    private CustomElement widgetType;

    @FindBy(xpath = ".//div[contains(@class, 'owner')]")
    private CustomElement owner;
}
