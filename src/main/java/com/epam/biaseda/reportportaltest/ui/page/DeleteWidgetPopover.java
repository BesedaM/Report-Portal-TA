package com.epam.biaseda.reportportaltest.ui.page;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

@Getter
public class DeleteWidgetPopover extends CustomElement{

    @Name("Popover title")
    @FindBy(xpath = ".//span[contains(@class, 'modal-title')]")
    private CustomElement title;

    @FindBy(xpath = ".//div[contains(@class, 'close-modal-icon')]")
    private CustomElement closeButton;

    @FindBy(xpath = ".//div[contains(@class, 'modal-content')]")
    private CustomElement content;

    @FindBy(xpath = ".//span[contains(@class, 'warning-message')]")
    private CustomElement message;

    @Name("Cancel button")
    @FindBy(xpath = ".//div[1]/button[contains(@class, 'big-button')]")
    private CustomElement cancelButton;

    @Name("Delete button")
    @FindBy(xpath = ".//div[2]/button[contains(@class, 'big-button')]")
    private CustomElement deleteButton;

}
