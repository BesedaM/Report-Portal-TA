package com.epam.biaseda.reportportaltest.ui.selenide.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class GridView {

    @FindBy(xpath = "//div[contains(@class, 'page-content')]/h3[1]")
    private SelenideElement MY_DASHBOARDS_HEADER;
    @FindBy(xpath = "//div[contains(@class, 'dashboardGridItem')]/a")
    private ElementsCollection DASHBOARD_LIST;
    @FindBy(xpath = "//div[contains(@class, 'page-content')]/h3[1]")
    private SelenideElement SHARED_DASHBOARDS_HEADER;
}
