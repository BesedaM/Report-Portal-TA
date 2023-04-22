package com.epam.biaseda.reportportaltest.ui.service;

import com.epam.biaseda.reportportaltest.ui.page.DashboardPage;
import com.epam.biaseda.reportportaltest.ui.page.DashboardsPage;

public class DashboardsUIService {

    public static void openDashboard(String title) {
        new DashboardsPage().getTableView().getDashboardByTitle(title).getDashboardName().click();
        new DashboardPage().waitForPageLoaded();
    }
}
