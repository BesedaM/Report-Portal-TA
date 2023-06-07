package com.epam.biaseda.reportportaltest.ui.selenide.service;

import com.codeborne.selenide.SelenideElement;
import com.epam.biaseda.reportportaltest.ui.selenide.page.DashboardPage;
import com.epam.biaseda.reportportaltest.ui.selenide.page.block.TableView;

import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$$;
import static com.epam.biaseda.reportportaltest.ui.selenide.page.block.TableView.DASHBOARD_NAME_ELEMENT;

public class DashboardsUIService {

    public static void openDashboard(String title) {
        SelenideElement dashboardName = $$(TableView.TABLE_ROW_LIST)
                .stream()
                .filter(tablerow -> tablerow.$(DASHBOARD_NAME_ELEMENT).getText().equals(title))
                .map(tablerow -> tablerow.$(DASHBOARD_NAME_ELEMENT))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(String.format("Unable to find Dashboard with name '%s'!", title)));
        dashboardName.click();
        DashboardPage.waitForPageLoaded();
    }
}
