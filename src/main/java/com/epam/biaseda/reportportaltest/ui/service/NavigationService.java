package com.epam.biaseda.reportportaltest.ui.service;

import com.epam.biaseda.reportportaltest.ui.page.BasePage;
import com.epam.biaseda.reportportaltest.ui.page.DashboardsPage;
import com.epam.biaseda.reportportaltest.ui.page.NavigationSidebarPanel;
import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.swing.text.html.HTML;


public class NavigationService {

    @AllArgsConstructor
    @Getter
    public enum MenuItem {
        DASHBOARDS("dashboards", () -> new DashboardsPage().waitForPageLoaded()),
        LAUNCHES("launches", () -> new BasePage().waitForPageLoaded()),
        FILTERS("filters", () -> new BasePage().waitForPageLoaded()),
        DEBUG("userdebug", () -> new BasePage().waitForPageLoaded()),
        PROJECT_MEMBERS("members", () -> new BasePage().waitForPageLoaded()),
        PROJECT_SETTINGS("settings", () -> new BasePage().waitForPageLoaded());

        private String searchElement;
        private Runnable waitForPageLoaded;

        public void waitForPageLoaded() {
            waitForPageLoaded.run();
        }
    }

    public static void selectMenuElement(MenuItem menuItem) {
        CustomElement menuElement = new NavigationSidebarPanel().getMenuElement(menuItem);
        if (!menuElement.getAttribute(HTML.Attribute.CLASS.toString()).contains("active"))
            new NavigationSidebarPanel().getMenuElement(menuItem).click();
        menuItem.waitForPageLoaded();
    }

}
