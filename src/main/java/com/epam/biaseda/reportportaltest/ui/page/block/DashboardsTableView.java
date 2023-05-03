package com.epam.biaseda.reportportaltest.ui.page.block;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.util.List;

@Getter
public class DashboardsTableView extends CustomElement {

    @Name("'Dashboard name' header")
    @FindBy(xpath = "//div[contains(@class, 'header-cell')][1]//div[contains(@class, 'title')]")
    private CustomElement dashboardNameHeader;

    @Name("'Dashboard name' description header")
    @FindBy(xpath = "//div[contains(@class, 'header-cell')][2]//div[contains(@class, 'title')]")
    private CustomElement descriptionHeader;

    @Name("'Owner' header")
    @FindBy(xpath = "//div[contains(@class, 'header-cell')][3]//div[contains(@class, 'title')]")
    private CustomElement ownerHeader;

    @Name("'Shared' header")
    @FindBy(xpath = "//div[contains(@class, 'header-cell')][4]//div[contains(@class, 'title')]")
    private CustomElement sharedHeader;

    @Name("'Edit' header")
    @FindBy(xpath = "//div[contains(@class, 'header-cell')][5]//div[contains(@class, 'title')]")
    private CustomElement editHeader;

    @Name("'Delete' header")
    @FindBy(xpath = "//div[contains(@class, 'header-cell')][6]//div[contains(@class, 'title')]")
    private CustomElement deleteHeader;

    @FindBy(xpath = "//div[@data-id]")
    private List<DashboardsTablerow> tableRowList;

    public DashboardsTablerow getDashboardByTitle(String title) {
        return getTableRowList().stream()
                .filter(tablerow -> tablerow.getDashboardName().getText().equals(title)).findFirst().orElse(null);
    }
}
