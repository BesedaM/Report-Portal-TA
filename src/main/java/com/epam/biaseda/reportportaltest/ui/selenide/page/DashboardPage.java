package com.epam.biaseda.reportportaltest.ui.selenide.page;

import com.codeborne.selenide.SelenideElement;
import com.epam.biaseda.reportportaltest.ui.selenide.page.block.Widget;
import com.epam.biaseda.reportportaltest.ui.selenide.service.action.WaitAction;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$$;

@Getter
public class DashboardPage {

    public static final By ALL_DASH_BOARDS_LINK = By.xpath("//a[contains(@class,'page-breadcrumbs')]");
    public static final By SELECTED_DASHBOARD_TITLE = By.xpath("//div[contains(@class,'page-header')]//span[@title]");
    public static final By ADD_NEW_DASHBOARD_BUTTON = By.xpath("//div[contains(@class,'addDashboardButton')]");
    public static final By ADD_NEW_WIDGET_BUTTON = By.xpath("//div[contains(@class,'buttons-container')]/div[1]/button[1]");
    public static final By ADD_SHARED_WIDGET_BUTTON = By.xpath("//div[contains(@class,'buttons-container')]/div[1]/button[2]");
    public static final By EDIT_BUTTON = By.xpath("//div[contains(@class,'buttons-container')]/div[2]/button[1]");
    public static final By FULL_SCREEN_BUTTON = By.xpath("//div[contains(@class,'buttons-container')]/div[2]/button[2]");
    public static final By DELETE_BUTTON = By.xpath("//div[contains(@class,'buttons-container')]/div[2]/button[3]");
    public static final By PRINT_BUTTON = By.xpath("//div[contains(@class,'buttons-container')]/div[2]/a");

    public static final By WIDGET_LIST = By.xpath("//div[contains(@class,'widget-view')]");
    public static final By DELETE_WIDGET_POPOVER = By.xpath("//div[contains(@class, 'modal-window')]");

    public static void waitForPageLoaded() {
        WaitAction.waitUntilCollectionNotEmpty($$(WIDGET_LIST));
        WaitAction.waitUntilVisible($$(WIDGET_LIST).get(0).$(Widget.WIDGET_TITLE));
    }

    public static SelenideElement getWidget(String widgetTitle) {
        return $$(WIDGET_LIST).stream()
                .filter(widget -> widget.$(Widget.WIDGET_TITLE).getText().equals(widgetTitle)).findFirst()
                .orElseThrow(() -> new NoSuchElementException(String.format("Widget with title %s was not found!", widgetTitle)));
    }
}
