package com.epam.biaseda.reportportaltest.ui.page.block;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class DashboardsGridView extends CustomElement {

    @FindBy(xpath = "//div[contains(@class, 'page-content')]/h3[1]")
    private CustomElement myDashboardsHeader;

    @FindBy(xpath = "//div[contains(@class, 'dashboardGridItem')]/a")
    private List<CustomElement> dashboardList;

    @FindBy(xpath = "//div[contains(@class, 'page-content')]/h3[1]")
    private CustomElement sharedDashboardsHeader;
}
