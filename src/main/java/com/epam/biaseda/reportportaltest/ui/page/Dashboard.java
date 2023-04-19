package com.epam.biaseda.reportportaltest.ui.page;

import com.epam.biaseda.reportportaltest.ui.driver.action.WaitAction;
import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class Dashboard extends BasePage {

    @FindBy(xpath = "//a[contains(@class,'page-breadcrumbs')]")
    private CustomElement allDashBoardsLink;

    @FindBy(xpath = "//div[contains(@class,'addDashboardButton')]")
    private CustomElement addNewDashboard;

    @FindBy(xpath = "//div[contains(@class,'buttons-container')]//button")
    private List<CustomElement> dashboardButtons;

    @FindBy(xpath = "//div[contains(@class,'widget-view')]")
    private List<CustomElement> widgets;

    @Override
    public void waitForPageLoaded() {
        WaitAction.waitUntilVisible(allDashBoardsLink);
    }

    public CustomElement getAddNewWidgetButton() {
        return dashboardButtons.get(0);
    }

    public CustomElement getAddSharedWidgetButton() {
        return dashboardButtons.get(1);
    }

    public CustomElement getEditButton() {
        return dashboardButtons.get(2);
    }

    public CustomElement getFullScreenButton() {
        return dashboardButtons.get(3);
    }

    public CustomElement getDeleteButton() {
        return dashboardButtons.get(4);
    }

    public CustomElement getPrintButton() {
        return dashboardButtons.get(5);
    }
}
