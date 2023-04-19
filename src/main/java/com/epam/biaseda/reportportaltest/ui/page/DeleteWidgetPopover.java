package com.epam.biaseda.reportportaltest.ui.page;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class DeleteWidgetPopover extends BasePage{

    @FindBy(xpath = "//span[contains(@class, 'modal-title')]")
    private CustomElement title;

    @FindBy(xpath = "//div[contains(@class, 'close-modal-icon')]")
    private CustomElement closeButton;

    @FindBy(xpath = "//div[contains(@class, 'modal-content')]")
    private CustomElement content;

    @FindBy(xpath = "//span[contains(@class, 'warning-message')]")
    private CustomElement message;

    @FindBy(xpath = "//button[contains(@class, 'big-button')][1]")
    private CustomElement cancelButton;

    @FindBy(xpath = "//button[contains(@class, 'big-button')][2]")
    private CustomElement deleteButton;

}
