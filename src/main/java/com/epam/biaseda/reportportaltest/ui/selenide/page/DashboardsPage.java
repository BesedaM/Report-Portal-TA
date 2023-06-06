package com.epam.biaseda.reportportaltest.ui.selenide.page;

import com.codeborne.selenide.Condition;
import com.epam.biaseda.reportportaltest.ui.selenide.page.block.TableView;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DashboardsPage {

    public static final By HEADER = By.xpath("//div[contains(@class, 'page-header')]/ul");
    public static final By ADD_NEW_DASHBOARD_BUTTON = By.xpath("//div[contains(@class, 'add-dashboard')]");
    public static final By GRID_VIEW_BUTTON = By.xpath("//div[contains(@class, 'active')]/button[1]");
    public static final By TABLE_VIEW_BUTTON = By.xpath("//div[contains(@class, 'active')]/button[2]");

    public static final By GRID_VIEW = By.xpath("//div[contains(@class, 'page-content')]");
    public static final By TABLE_VIEW = By.xpath("//div[contains(@class, 'dashboard-table')]");

    public void waitForTableViewLoaded() {
        $(TABLE_VIEW).shouldBe(Condition.exist);
        $(TABLE_VIEW).$(TableView.DASHBOARD_NAME_HEADER).shouldBe(Condition.visible);
    }
}
