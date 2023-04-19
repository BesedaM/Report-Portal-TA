package com.epam.biaseda.reportportaltest.ui.page.block;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import org.openqa.selenium.support.FindBy;

public class Widget extends CustomElement {

    @FindBy(xpath=".//div[contains(@class, 'name-block')]")
    private CustomElement name;

    @FindBy(xpath = ".//div[contains(@class, 'type')]")
    private CustomElement widgetType;

    @FindBy(xpath = ".//div[contains(@class, 'meta-info')]")
    private CustomElement viewType;

    @FindBy(xpath = ".//div[contains(@class, 'common-control')]//div[contains(@class, 'control')][1]")
    private CustomElement editButton;

    @FindBy(xpath = ".//div[contains(@class, 'common-control')]//div[contains(@class, 'control')][2]")
    private CustomElement reloadButton;

    @FindBy(xpath = ".//div[contains(@class, 'common-control')]//div[contains(@class, 'control')][3]")
    private CustomElement deleteButton;
}
