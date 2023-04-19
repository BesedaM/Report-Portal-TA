package com.epam.biaseda.reportportaltest.ui.service;

import com.epam.biaseda.reportportaltest.ui.page.Dashboard;
import com.epam.biaseda.reportportaltest.ui.page.DashboardsPage;

public class DashboardsPageService {

    public static void openDashboard(String title) {
        new DashboardsPage().getDashboardByTitle(title).click();
        new Dashboard().waitForPageLoaded();
    }
}
