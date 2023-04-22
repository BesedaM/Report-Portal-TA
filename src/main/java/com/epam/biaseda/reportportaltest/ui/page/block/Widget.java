package com.epam.biaseda.reportportaltest.ui.page.block;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

@Getter
public class Widget extends CustomElement {

    @Name("Widget title")
    @FindBy(xpath=".//div[contains(@class, 'name-block')]")
    private CustomElement widgetTitle;

    @Name("Widget type")
    @FindBy(xpath = ".//div[contains(@class, 'type')]/span")
    private CustomElement widgetType;

    @Name("Widget view type")
    @FindBy(xpath = ".//div[contains(@class, 'type')]/div")
    private CustomElement widgetViewType;

    @Name("Edit button")
    @FindBy(xpath = ".//div[contains(@class, 'common-control')]//div[contains(@class, 'control')][1]")
    private CustomElement editButton;

    @Name("Reload button")
    @FindBy(xpath = ".//div[contains(@class, 'common-control')]//div[contains(@class, 'control')][2]")
    private CustomElement reloadButton;

    @Name("Delete button")
    @FindBy(xpath = ".//div[contains(@class, 'common-control')]//div[contains(@class, 'control')][3]")
    private CustomElement deleteButton;

    @Name("Widget content")
    @FindBy(xpath = ".//div[contains(@class, 'widget')]")
    private CustomElement content;
}
