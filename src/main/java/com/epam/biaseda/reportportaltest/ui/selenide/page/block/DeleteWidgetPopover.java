package com.epam.biaseda.reportportaltest.ui.selenide.page.block;

import org.openqa.selenium.By;

public class DeleteWidgetPopover {

    public static final By TITLE = By.xpath(".//span[contains(@class, 'modal-title')]");
    public static final By CLOSE_BUTTON = By.xpath(".//div[contains(@class, 'close-modal-icon')]");
    public static final By CONTENT = By.xpath(".//div[contains(@class, 'modal-content')]");
    public static final By MESSAGE = By.xpath(".//span[contains(@class, 'warning-message')]");
    public static final By CANCEL_BUTTON = By.xpath(".//div[1]/button[contains(@class, 'big-button')]");
    public static final By DELETE_BUTTON = By.xpath(".//div[2]/button[contains(@class, 'big-button')]");
}
