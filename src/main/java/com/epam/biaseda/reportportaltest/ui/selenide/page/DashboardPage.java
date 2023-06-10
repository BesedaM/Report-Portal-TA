package com.epam.biaseda.reportportaltest.ui.selenide.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.epam.biaseda.reportportaltest.ui.selenide.page.block.DeleteWidgetPopover;
import com.epam.biaseda.reportportaltest.ui.selenide.page.block.Widget;
import com.epam.biaseda.reportportaltest.ui.selenide.service.action.WaitAction;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Getter
public class DashboardPage {

    @FindBy(xpath = "//a[contains(@class,'page-breadcrumbs')]")
    private SelenideElement allDashBoardsLink;

    @FindBy(xpath = "//div[contains(@class,'page-header')]//span[@title]")
    private SelenideElement selectedDashboardTitle;

    @FindBy(xpath = "//div[contains(@class,'addDashboardButton')]")
    private SelenideElement addNewDashboardButton;

    @FindBy(xpath = "//div[contains(@class,'buttons-container')]/div[1]/button[1]")
    private SelenideElement addNewWidgetButton;

    @FindBy(xpath = "//div[contains(@class,'buttons-container')]/div[1]/button[2]")
    private SelenideElement addSharedWidgetButton;

    @FindBy(xpath = "//div[contains(@class,'buttons-container')]/div[2]/button[1]")
    private SelenideElement editButton;

    @FindBy(xpath = "//div[contains(@class,'buttons-container')]/div[2]/button[2]")
    private SelenideElement fullScreenButton;

    @FindBy(xpath = "//div[contains(@class,'buttons-container')]/div[2]/button[3]")
    private SelenideElement deleteButton;

    @FindBy(xpath = "//div[contains(@class,'buttons-container')]/div[2]/a")
    private SelenideElement printButton;

    @FindBy(xpath = "//div[contains(@class,'widget-view')]")
    private ElementsCollection widgetList;

    @FindBy(xpath = "//div[contains(@class, 'modal-window')]")
    private SelenideElement deleteWidgetPopover;

    public void waitForPageLoaded() {
        WaitAction.waitUntilCollectionNotEmpty(widgetList);
        WaitAction.waitUntilVisible(getWidgetList().get(0).getTitle());
    }

    public Widget getWidget(String widgetTitle) {
        return widgetList
                .asFixedIterable().stream()
                .filter(widget -> new Widget(widget).getTitle().getText().equals(widgetTitle))
                .map(Widget::new)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(String.format("Widget with title %s was not found!", widgetTitle)));
    }

    public List<Widget> getWidgetList() {
        return widgetList.asFixedIterable().stream()
                .map(Widget::new).collect(Collectors.toList());
    }

    public DeleteWidgetPopover getDeleteWidgetPopover( ){
        return new DeleteWidgetPopover(deleteWidgetPopover);
    }
}
