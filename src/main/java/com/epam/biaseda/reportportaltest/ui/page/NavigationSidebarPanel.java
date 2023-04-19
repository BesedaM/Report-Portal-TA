package com.epam.biaseda.reportportaltest.ui.page;

import com.epam.biaseda.reportportaltest.ui.driver.action.WaitAction;
import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import com.epam.biaseda.reportportaltest.ui.service.NavigationService;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

@Getter
public class NavigationSidebarPanel extends BasePage {

    @FindBy(xpath=".//div[contains(@class, 'current-project-block')]")
    private CustomElement currentProject;

    @FindBy(xpath = ".//a[contains(@href,'#default_personal')]")
    private List<CustomElement> menuItems;

    @FindBy(xpath=".//div[contains(@class, 'user-block')]")
    private CustomElement user;

    @Override
    public void waitForPageLoaded(){
        WaitAction.waitUntilVisible(getCurrentProject());
    }

    public CustomElement getMenuElement(NavigationService.MenuItem menuItem) {
        List<CustomElement> actualElements = getMenuItems();

        return actualElements.stream()
                .filter(element -> element.getAttribute("href").contains(menuItem.getSearchElement()))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException(String.format("Side Menu '%s' not found!", menuItem)));
    }
}
