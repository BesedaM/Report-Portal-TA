package com.epam.biaseda.reportportaltest.ui.selenide.page.block;

import org.openqa.selenium.By;

public class Widget {

    public static final By WIDGET_TITLE = By.xpath(".//div[contains(@class, 'name-block')]");
    public static final By WIDGET_TYPE = By.xpath(".//div[contains(@class, 'type')]/span");
    public static final By WIDGET_VIEW_TYPE = By.xpath(".//div[contains(@class, 'type')]/div");
    public static final By EDIT_BUTTON = By.xpath(".//div[contains(@class, 'common-control')]//div[contains(@class, 'control')][1]");
    public static final By RELOAD_BUTTON = By.xpath(".//div[contains(@class, 'common-control')]//div[contains(@class, 'control')][2]");
    public static final By DELETE_BUTTON = By.xpath(".//div[contains(@class, 'common-control')]//div[contains(@class, 'control')][3]");
    public static final By CONTENT = By.xpath(".//div[contains(@class, 'widget')]");
}
