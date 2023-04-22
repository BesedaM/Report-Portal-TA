package com.epam.biaseda.reportportaltest.ui.page;

import com.epam.biaseda.reportportaltest.ui.driver.action.WaitAction;
import com.epam.biaseda.reportportaltest.ui.page.block.DashboardsGridView;
import com.epam.biaseda.reportportaltest.ui.page.block.DashboardsTableView;
import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

@Getter
public class DashboardsPage extends BasePage {

    @Name("Dashboards page header")
    @FindBy(xpath = "//div[contains(@class, 'page-header')]/ul")
    private CustomElement header;

    @Name("'Add dashboard' button")
    @FindBy(xpath = "//div[contains(@class, 'add-dashboard')]")
    private CustomElement addNewDashboardButton;

    @Name("'Grid view' button")
    @FindBy(xpath = "//div[contains(@class, 'active')]/button[1]")
    private CustomElement gridViewButton;

    @Name("'Table view' button")
    @FindBy(xpath = "//div[contains(@class, 'active')]/button[2]")
    private CustomElement tableViewButton;

    @FindBy(xpath = "//div[contains(@class, 'dashboard-table')]")
    private DashboardsTableView tableView;

    @FindBy(xpath = "//div[contains(@class, 'page-content')]")
    private DashboardsGridView gridView;

    @Override
    public void waitForPageLoaded() {
        WaitAction.getWebDriverWait()
                .withMessage("Dashboards page was not loaded!")
                .until(driver -> getGridView().getDashboardList().size() > 0
                        || getTableView().getDashboardNameHeader().isDisplayed());
    }
}
