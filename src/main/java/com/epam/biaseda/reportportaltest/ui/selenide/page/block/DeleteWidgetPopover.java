package com.epam.biaseda.reportportaltest.ui.selenide.page.block;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;

@AllArgsConstructor
public class DeleteWidgetPopover {

    private static final By TITLE = By.xpath(".//span[contains(@class, 'modal-title')]");
    private static final By CLOSE_BUTTON = By.xpath(".//div[contains(@class, 'close-modal-icon')]");
    private static final By CONTENT = By.xpath(".//div[contains(@class, 'modal-content')]");
    private static final By MESSAGE = By.xpath(".//span[contains(@class, 'warning-message')]");
    private static final By CANCEL_BUTTON = By.xpath(".//div[1]/button[contains(@class, 'big-button')]");
    private static final By DELETE_BUTTON = By.xpath(".//div[2]/button[contains(@class, 'big-button')]");


    private SelenideElement element;

    public SelenideElement getElement(){
        return element;
    }

    public SelenideElement getTitle(){
        return element.$(TITLE);
    }

    public SelenideElement getCloseButton(){
        return element.$(CLOSE_BUTTON);
    }

    public SelenideElement getContent(){
        return element.$(CONTENT);
    }

    public SelenideElement getMoessage(){
        return element.$(MESSAGE);
    }

    public SelenideElement getCancelButton(){
        return element.$(CANCEL_BUTTON);
    }

    public SelenideElement getDeleteButton(){
        return element.$(DELETE_BUTTON);
    }
}
