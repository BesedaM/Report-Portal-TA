package com.epam.biaseda.reportportaltest.ui.selenide.page.block;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;

@AllArgsConstructor
public class DashboardTableRow {

    private SelenideElement tableRow;

    private static final By DASHBOARD_NAME_ELEMENT = By.xpath(".//*[contains(@class, 'dashboardTable__name')]");
    private static final By DESCRIPTION_ELEMENT = By.xpath(".//*[contains(@class, 'dashboardTable__description')]");
    private static final By OWNER_ELEMENT = By.xpath(".//*[contains(@class, 'dashboardTable__owner')]");
    private static final By SHARED_ELEMENT = By.xpath(".//*[contains(@class, 'dashboardTable__icon-cell')][1]");
    private static final By EDIT_ELEMENT = By.xpath(".//*[contains(@class, 'dashboardTable__icon-cell')][2]");
    private static final By DELETE_ELEMENT = By.xpath(".//*[contains(@class, 'dashboardTable__icon-cell')][3]");

    public SelenideElement getName() {
        return tableRow.$(DASHBOARD_NAME_ELEMENT);
    }

    public SelenideElement getDescription() {
        return tableRow.$(DESCRIPTION_ELEMENT);
    }

    public SelenideElement getOwner() {
        return tableRow.$(OWNER_ELEMENT);
    }

    public SelenideElement getShared() {
        return tableRow.$(SHARED_ELEMENT);
    }

    public SelenideElement getEdit() {
        return tableRow.$(EDIT_ELEMENT);
    }

    public SelenideElement getDelete() {
        return tableRow.$(DELETE_ELEMENT);
    }
}
