package com.epam.biaseda.reportportaltest.ui.page.block;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavigationSidebar extends CustomElement {

    @FindBy(xpath=".//div[contains(@class, 'current-project-block')]")
    private CustomElement currentProject;

    @FindBy(xpath = ".//a[contains(@href,'#default_personal')]")
    private List<CustomElement> menuItems;

    @FindBy(xpath=".//div[contains(@class, 'user-block')]")
    private CustomElement user;
}
