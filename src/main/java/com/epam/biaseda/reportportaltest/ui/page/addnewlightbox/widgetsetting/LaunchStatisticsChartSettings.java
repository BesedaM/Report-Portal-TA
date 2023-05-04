package com.epam.biaseda.reportportaltest.ui.page.addnewlightbox.widgetsetting;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import com.epam.biaseda.reportportaltest.ui.page.element.CustomToggle;
import com.epam.biaseda.reportportaltest.ui.page.element.LabeledInputDropdown;
import com.epam.biaseda.reportportaltest.ui.page.element.ModalInputField;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class LaunchStatisticsChartSettings extends CustomElement {

    @FindBy(xpath = "./div[contains(@class,'modal-field')][1]")
    private LabeledInputDropdown criteriaForWidget;

    @FindBy(xpath = "./div[contains(@class,'modal-field')][2]")
    private ModalInputField items;

    @FindBy(xpath="./div[contains(@class,'modal-field')][3]//div[contains(@class,'toggle-button')]")
    private CustomToggle modeToggle;

    @FindBy(xpath="./div[contains(@class,'modal-field')][4]//div[contains(@class,'toggle-button')]")
    private CustomToggle viewToggle;


}
