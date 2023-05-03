package com.epam.biaseda.reportportaltest.ui.page.lightbox;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import com.epam.biaseda.reportportaltest.ui.page.element.CustomRadioButton;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class AddNewWidgetLightboxStep1 extends AddNewWidgetLightbox{

    @FindBy(xpath = "//div[contains(@class, 'widget-type-selector-heading')]")
    private CustomElement widgetTypeSelectorHeading;

    @FindBy(xpath = "//div[@class='widget-type-selector']//div[contains(@class, 'widget-type-item')]")
    private List<CustomRadioButton> widgetTypeItemList;

    @FindBy(xpath = "//div[contains(@class,'button')]/button")
    private CustomElement nextStepButton;
}
