package com.epam.biaseda.reportportaltest.ui.selenide.page.block;

import org.openqa.selenium.By;

public class GridView {

    public static final By MY_DASHBOARDS_HEADER = By.xpath("//div[contains(@class, 'page-content')]/h3[1]");
    public static final By DASHBOARD_LIST = By.xpath("//div[contains(@class, 'dashboardGridItem')]/a");
    public static final By SHARED_DASHBOARDS_HEADER = By.xpath("//div[contains(@class, 'page-content')]/h3[1]");
}
