package com.epam.biaseda.reportportaltest.ui.selenide.service;

import com.codeborne.selenide.SelenideElement;
import com.epam.biaseda.reportportaltest.ui.selenide.page.NavigationSidebarPanel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.swing.text.html.HTML;


public class NavigationUIService {

    @AllArgsConstructor
    @Getter
    public enum MenuItem {
        DASHBOARDS("dashboards"),
        LAUNCHES("launches"),
        FILTERS("filters"),
        DEBUG("userdebug"),
        PROJECT_MEMBERS("members"),
        PROJECT_SETTINGS("settings");

        private String searchElement;
    }

    public static void selectMenuElement(MenuItem menuItem) {
        SelenideElement menuElement = new NavigationSidebarPanel().getMenuElement(menuItem);
        if (!menuElement.getAttribute(HTML.Attribute.CLASS.toString()).contains("active"))
            new NavigationSidebarPanel().getMenuElement(menuItem).click();
    }

}
