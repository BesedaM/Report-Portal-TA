package com.epam.biaseda.reportportaltest.ui.page.block;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class DashboardPreview extends CustomElement {

    @FindBy(xpath=".//h3")
    private CustomElement title;

    @FindBy(xpath=".//div[contains(@class, 'shared')]")
    private CustomElement isSharedElement;

    @FindBy(xpath = ".//div[contains(@class, 'edit')]")
    private CustomElement edit;

    @FindBy(xpath = ".//div[contains(@class, 'delete')]")
    private CustomElement delete;
}
