package com.epam.biaseda.reportportaltest.ui.page.lightbox;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class AddNewWidgetLightboxStep2 extends AddNewWidgetLightbox {

    @FindBy(xpath = "//input[contains(@class,'inputSearch')]")
    private CustomElement search;

    @FindBy(xpath = "//div[contains(@class,'filters-header')]/button")
    private CustomElement addFilterButton;

    @FindBy(xpath = "//div[contains(@class,'activeFilter')]")
    private CustomElement activeFilter;

    @FindBy(xpath = "//div[contains(@class, 'filter-item')]")
    private List<CustomElement> filterList;

    //TODO add missing elements

    @FindBy(xpath = "//div[contains(@class, 'wizardControlsSection')]/button[1]")
    private CustomElement previousStepButton;

    @FindBy(xpath = "//div[contains(@class, 'wizardControlsSection')]/button[2]")
    private CustomElement nextStepButton;
}
