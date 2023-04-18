package com.epam.biaseda.reportportaltest.ui.page;

import com.epam.biaseda.reportportaltest.ui.page.block.NavigationSidebar;
import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class DashboardsPage extends BasePage{

    @FindBy(xpath = "//div[contains(@class, 'page-header')]/ul")
    private CustomElement header;

    @FindBy(xpath = "//div[contains(@class, 'pageSwitcher')]//div[contains(@class, 'sidebar-container')]")
    private NavigationSidebar navigationSidebar;

    @FindBy(xpath = "//div[contains(@class, 'dashboardGridItem')]/a")
    private List<CustomElement> dashboardList;


}
