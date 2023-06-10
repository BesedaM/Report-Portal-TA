package com.epam.biaseda.reportportaltest.ui.selenide.service;

import com.epam.biaseda.reportportaltest.ui.selenide.page.DashboardPage;
import com.epam.biaseda.reportportaltest.ui.selenide.page.block.DashboardTableRow;
import com.epam.biaseda.reportportaltest.ui.selenide.page.TableView;

import static com.codeborne.selenide.Selenide.page;

public class DashboardsUIService {

    private static TableView tableView = page(new TableView());
    private static DashboardPage dashboardPage = page(new DashboardPage());

    public static void openDashboard(String name) {
        DashboardTableRow dashboardRow = tableView.getTableRow(name);
        dashboardRow.getName().click();
        dashboardPage.waitForPageLoaded();
    }
}
