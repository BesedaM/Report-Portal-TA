package com.epam.biaseda.reportportaltest.ui.selenide.page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class DashboardsPage {

    @FindBy(xpath = "//div[contains(@class, 'page-header')]/ul")
    private SelenideElement header;
    @FindBy(xpath = "//div[contains(@class, 'add-dashboard')]")
    private SelenideElement addNewDashboardButton;
    @FindBy(xpath = "//div[contains(@class, 'active')]/button[1]")
    private SelenideElement gridViewButton;
    @FindBy(xpath = "//div[contains(@class, 'active')]/button[2]")
    private SelenideElement tableViewButton;

    @FindBy(xpath = "//div[contains(@class, 'page-content')]")
    private SelenideElement gridView;
    @FindBy(xpath = "//div[contains(@class, 'dashboard-table')]")
    private SelenideElement tableView;
}
