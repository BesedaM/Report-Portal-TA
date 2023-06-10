package com.epam.biaseda.reportportaltest.ui.selenide.page.block;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;

@AllArgsConstructor
public class Widget {
    
    private static final By HEADER = By.xpath(".//div[contains(@class, 'widget-header')]");
    private static final By TITLE = By.xpath(".//div[contains(@class, 'name-block')]");
    private static final By TYPE = By.xpath(".//div[contains(@class, 'type')]/span");
    private static final By VIEW_TYPE = By.xpath(".//div[contains(@class, 'type')]/div");
    private static final By EDIT_BUTTON = By.xpath(".//div[contains(@class, 'common-control')]//div[contains(@class, 'control')][1]");
    private static final By RELOAD_BUTTON = By.xpath(".//div[contains(@class, 'common-control')]//div[contains(@class, 'control')][2]");
    private static final By DELETE_BUTTON = By.xpath(".//div[contains(@class, 'common-control')]//div[contains(@class, 'control')][3]");
    private static final By CONTENT = By.xpath(".//div[contains(@class, 'widget')]");
    private static final By RESIZABLE_HANDLE = By.xpath("./span");

    private SelenideElement element;

    public SelenideElement getElement(){
        return element;
    }

    public SelenideElement getHeader(){
        return element.$(HEADER);
    }

    public SelenideElement getTitle(){
        return element.$(TITLE);
    }

    public SelenideElement getType(){
        return element.$(TYPE);
    }

    public SelenideElement getViewType(){
        return element.$(VIEW_TYPE);
    }

    public SelenideElement getEditButton(){
        return element.$(EDIT_BUTTON);
    }

    public SelenideElement getReloadButton(){
        return element.$(RELOAD_BUTTON);
    }

    public SelenideElement getDeleteButton(){
        return element.$(DELETE_BUTTON);
    }

    public SelenideElement getContent(){
        return element.$(CONTENT);
    }

    public SelenideElement getResizableHandle(){
        return element.$(RESIZABLE_HANDLE);
    }
}
