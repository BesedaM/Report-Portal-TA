package com.epam.biaseda.reportportaltest.ui.page.addnewlightbox;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class ConfigureWidgetLightbox extends AddNewWidgetLightbox{

    @FindBy(xpath = "//div[contains(@class, 'buttons-block')]/div[1]")
    private CustomElement previousStepButton;

    @FindBy(xpath = "//div[contains(@class, 'buttons-block')]/div[2]")
    private CustomElement nextStepButton;
}
