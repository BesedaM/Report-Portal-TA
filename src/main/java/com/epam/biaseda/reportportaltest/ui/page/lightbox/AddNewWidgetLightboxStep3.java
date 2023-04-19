package com.epam.biaseda.reportportaltest.ui.page.lightbox;

import com.epam.biaseda.reportportaltest.ui.page.element.ModalInputField;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class AddNewWidgetLightboxStep3 extends AddNewWidgetLightbox {

    @FindBy(xpath = "//div[contains(@class, 'modal-field--')][1]")
    private ModalInputField widgetName;

    @FindBy(xpath = "//div[contains(@class, 'modal-field--')][2]")
    private ModalInputField widgetDescription;

    //TODO add missing elements


}
