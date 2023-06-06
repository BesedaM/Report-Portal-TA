package com.epam.biaseda.reportportaltest.ui.selenide.service;

import com.codeborne.selenide.SelenideElement;
import com.epam.biaseda.reportportaltest.ui.selenide.page.DashboardPage;
import com.epam.biaseda.reportportaltest.ui.selenide.page.block.TableView;

import static com.codeborne.selenide.Selenide.$$;
import static com.epam.biaseda.reportportaltest.ui.selenide.page.block.TableView.DASHBOARD_NAME_ELEMENT;

public class DashboardsUIService {

    public static void openDashboard(String title) {
        SelenideElement tableRow = $$(TableView.TABLE_ROW_LIST)
                .stream()
                .filter(tablerow -> tablerow.$(DASHBOARD_NAME_ELEMENT).getText().equals(title)).findFirst().orElse(null);
        tableRow.$(DASHBOARD_NAME_ELEMENT).click();
        DashboardPage.waitForPageLoaded();
    }
}
