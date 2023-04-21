package com.epam.biaseda.reportportaltest.ui.page;

import com.epam.biaseda.reportportaltest.ui.driver.action.WaitAction;
import com.epam.biaseda.reportportaltest.ui.page.block.DashboardPreview;
import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class DashboardsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'page-header')]/ul")
    private CustomElement header;

    @FindBy(xpath="//div[contains(@class, 'page-content')]/h3[1]")
    private CustomElement myDashboardsHeader;

    @FindBy(xpath = "//div[contains(@class, 'dashboardGridItem')]/a")
    private List<DashboardPreview> dashboardList;

    @FindBy(xpath="//div[contains(@class, 'page-content')]/h3[1]")
    private CustomElement sharedDashboardsHeader;

    @Override
    public void waitForPageLoaded() {
        WaitAction.getWebDriverWait()
                .withMessage("Dashboards page was not loaded!")
                .until(driver -> getDashboardList().size() > 0 && getDashboardList().get(0).getTitle().isDisplayed());
    }

    public DashboardPreview getDashboardByTitle(String title) {
        return getDashboardList().stream()
                .filter(dashboard -> dashboard.getTitle().getText().equals(title)).findFirst().orElse(null);
    }
}
