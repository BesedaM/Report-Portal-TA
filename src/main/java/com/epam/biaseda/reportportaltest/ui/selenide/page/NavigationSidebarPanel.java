package com.epam.biaseda.reportportaltest.ui.selenide.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.epam.biaseda.reportportaltest.ui.selenide.service.NavigationUIService;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import javax.swing.text.html.HTML;
import java.util.NoSuchElementException;

@Getter
public class NavigationSidebarPanel {

    @FindBy(xpath = "//div[contains(@class, 'current-project-block')]")
    private SelenideElement currentProject;

    @FindBy(xpath = "//a[contains(@href,'#default_personal')]")
    private ElementsCollection menuItems;

    @FindBy(xpath = "//div[contains(@class, 'user-block')]")
    private SelenideElement user;

    public SelenideElement getMenuElement(NavigationUIService.MenuItem menuItem) {
        return menuItems.asFixedIterable().stream()
                .filter(element -> element.getAttribute(HTML.Attribute.HREF.toString()).contains(menuItem.getSearchElement()))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException(String.format("Side Menu '%s' not found!", menuItem)));
    }
}
