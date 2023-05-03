package com.epam.biaseda.reportportaltest.ui.page.block;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class DashboardsTablerow extends CustomElement {

    @FindBy(xpath = ".//*[contains(@class, 'dashboardTable__name')]")
    private CustomElement dashboardName;

    @FindBy(xpath = ".//*[contains(@class, 'dashboardTable__description')]")
    private CustomElement description;

    @FindBy(xpath = ".//*[contains(@class, 'dashboardTable__owner')]")
    private CustomElement owner;

    @FindBy(xpath = ".//*[contains(@class, 'dashboardTable__icon-cell')][1]")
    private CustomElement shared;

    @FindBy(xpath = ".//*[contains(@class, 'dashboardTable__icon-cell')][2]")
    private CustomElement edit;

    @FindBy(xpath = ".//*[contains(@class, 'dashboardTable__icon-cell')][3]")
    private CustomElement delete;
}
