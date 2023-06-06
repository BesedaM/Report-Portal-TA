package com.epam.biaseda.reportportaltest.ui.selenide.page;

import com.codeborne.selenide.SelenideElement;
import com.epam.biaseda.reportportaltest.ui.selenide.service.NavigationUIService;
import org.openqa.selenium.By;

import javax.swing.text.html.HTML;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$$;

public class NavigationSidebarPanel {

    public static final By CURRENT_PROJECT = By.xpath("//div[contains(@class, 'current-project-block')]");

    public static final By MENU_ITEMS = By.xpath("//a[contains(@href,'#default_personal')]");

    public static final By USER = By.xpath("//div[contains(@class, 'user-block')]");

    public SelenideElement getMenuElement(NavigationUIService.MenuItem menuItem) {
        return $$(MENU_ITEMS).stream()
                .filter(element -> element.getAttribute(HTML.Attribute.HREF.toString()).contains(menuItem.getSearchElement()))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException(String.format("Side Menu '%s' not found!", menuItem)));
    }
}
