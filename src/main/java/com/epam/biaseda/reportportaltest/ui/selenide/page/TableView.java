package com.epam.biaseda.reportportaltest.ui.selenide.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.epam.biaseda.reportportaltest.ui.selenide.page.block.DashboardTableRow;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;

@Getter
public class TableView {

    @FindBy(xpath = "//div[contains(@class, 'header-cell')][1]//div[contains(@class, 'title')]")
    private SelenideElement dashboardNameHeader;
    @FindBy(xpath = "//div[contains(@class, 'header-cell')][2]//div[contains(@class, 'title')]")
    private SelenideElement descriptionHeader;
    @FindBy(xpath = "//div[contains(@class, 'header-cell')][3]//div[contains(@class, 'title')]")
    private SelenideElement ownerHeader;
    @FindBy(xpath = "//div[contains(@class, 'header-cell')][4]//div[contains(@class, 'title')]")
    private SelenideElement sharedHeader;
    @FindBy(xpath = "//div[contains(@class, 'header-cell')][5]//div[contains(@class, 'title')]")
    private SelenideElement editHeader;
    @FindBy(xpath = "//div[contains(@class, 'header-cell')][6]//div[contains(@class, 'title')]")
    private SelenideElement deleteHeader;
    @FindBy(xpath = "//div[@data-id]")
    private ElementsCollection tableRowList;

    public DashboardTableRow getTableRow(String dashboardName) {
        SelenideElement tableRow = tableRowList
                .asFixedIterable().stream()
                .filter(tablerow -> new DashboardTableRow(tablerow).getName().getText().equals(dashboardName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(String.format("Unable to find Dashboard with name '%s'!", dashboardName)));
        return new DashboardTableRow(tableRow);
    }


}
