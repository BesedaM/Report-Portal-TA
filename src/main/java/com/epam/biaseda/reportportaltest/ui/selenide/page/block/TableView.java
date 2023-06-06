package com.epam.biaseda.reportportaltest.ui.selenide.page.block;

import org.openqa.selenium.By;

public class TableView {

    public static final By DASHBOARD_NAME_HEADER = By.xpath("//div[contains(@class, 'header-cell')][1]//div[contains(@class, 'title')]");
    public static final By DESCRIPTION_HEADER = By.xpath("//div[contains(@class, 'header-cell')][2]//div[contains(@class, 'title')]");
    public static final By OWNER_HEADER = By.xpath("//div[contains(@class, 'header-cell')][3]//div[contains(@class, 'title')]");
    public static final By SHARED_HEADER = By.xpath("//div[contains(@class, 'header-cell')][4]//div[contains(@class, 'title')]");
    public static final By EDIT_HEADER = By.xpath("//div[contains(@class, 'header-cell')][5]//div[contains(@class, 'title')]");
    public static final By DELETE_HEADER = By.xpath("//div[contains(@class, 'header-cell')][6]//div[contains(@class, 'title')]");
    public static final By TABLE_ROW_LIST = By.xpath("//div[@data-id]");

    //table row element locators
    public static final By DASHBOARD_NAME_ELEMENT = By.xpath(".//*[contains(@class, 'dashboardTable__name')]");
    public static final By DESCRIPTION_ELEMENT = By.xpath(".//*[contains(@class, 'dashboardTable__description')]");
    public static final By OWNER_ELEMENT = By.xpath(".//*[contains(@class, 'dashboardTable__owner')]");
    public static final By SHARED_ELEMENT = By.xpath(".//*[contains(@class, 'dashboardTable__icon-cell')][1]");
    public static final By EDIT_ELEMENT = By.xpath(".//*[contains(@class, 'dashboardTable__icon-cell')][2]");
    public static final By DELETE_ELEMENT = By.xpath(".//*[contains(@class, 'dashboardTable__icon-cell')][3]");
}
