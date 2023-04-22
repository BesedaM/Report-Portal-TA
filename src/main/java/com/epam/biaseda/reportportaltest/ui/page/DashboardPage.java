package com.epam.biaseda.reportportaltest.ui.page;

import com.epam.biaseda.reportportaltest.ui.driver.action.WaitAction;
import com.epam.biaseda.reportportaltest.ui.page.block.Widget;
import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.util.List;
import java.util.NoSuchElementException;

@Getter
public class DashboardPage extends BasePage {

    @Name("'All dashboards' link")
    @FindBy(xpath = "//a[contains(@class,'page-breadcrumbs')]")
    private CustomElement allDashBoardsLink;

    @Name("Selected dashboard title")
    @FindBy(xpath = "//div[contains(@class,'page-header')]//span[@title]")
    private CustomElement selectedDashboardTitle;

    @Name("Add new dashboard button")
    @FindBy(xpath = "//div[contains(@class,'addDashboardButton')]")
    private CustomElement addNewDashboardButton;

    @Name("'Add new widget' button")
    @FindBy(xpath = "//div[contains(@class,'buttons-container')]/div[1]/button[1]")
    private CustomElement addNewWidgetButton;

    @Name("'Add shared widget' button")
    @FindBy(xpath = "//div[contains(@class,'buttons-container')]/div[1]/button[2]")
    private CustomElement addSharedWidgetButton;

    @Name("'Edit' button")
    @FindBy(xpath = "//div[contains(@class,'buttons-container')]/div[2]/button[1]")
    private CustomElement editButton;

    @Name("'Full screen' button")
    @FindBy(xpath = "//div[contains(@class,'buttons-container')]/div[2]/button[2]")
    private CustomElement fullScreenButton;

    @Name("'Delete' button")
    @FindBy(xpath = "//div[contains(@class,'buttons-container')]/div[2]/button[3]")
    private CustomElement deleteButton;

    @Name("'Print' button")
    @FindBy(xpath = "//div[contains(@class,'buttons-container')]/div[2]/a")
    private CustomElement printButton;

    @Name("Widgets list")
    @FindBy(xpath = "//div[contains(@class,'widget-view')]")
    private List<Widget> widgets;

    @FindBy(xpath = "//div[contains(@class, 'modal-window')]")
    private DeleteWidgetPopover deleteWidgetPopover;

    @Override
    public void waitForPageLoaded() {
        WaitAction.getWebDriverWait()
                .until(driver -> widgets.size() > 0 && widgets.get(0).getWidgetTitle().isDisplayed());
    }

    public Widget getWidget(String widgetTitle) {
        return widgets.stream()
                .filter(widget -> widget.getWidgetTitle().getText().equals(widgetTitle)).findFirst()
                .orElseThrow(() -> new NoSuchElementException(String.format("Widget with title %s was not found!", widgetTitle)));
    }
}
