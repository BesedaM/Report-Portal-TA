package com.epam.biaseda.reportportaltest.ui.page.addnewlightbox;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class AddWidgetFilterSettings extends CustomElement {

    @FindBy(xpath = "//input[contains(@class,'inputSearch')]")
    private CustomElement search;

    @FindBy(xpath = "//div[contains(@class,'filters-header')]/button")
    private CustomElement addFilterButton;

    @FindBy(xpath = "//div[contains(@class,'activeFilter')]")
    private CustomElement activeFilter;

    @FindBy(xpath = "//div[contains(@class, 'filter-item')]")
    private List<CustomElement> filterList;
}
