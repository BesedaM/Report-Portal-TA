package com.epam.biaseda.reportportaltest.ui.page.addnewlightbox;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import com.epam.biaseda.reportportaltest.ui.page.element.CustomRadioButton;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

@Getter
public class SelectWidgetTypeLightbox extends AddNewWidgetLightbox {

    @FindBy(xpath = "//div[contains(@class, 'widget-type-selector-heading')]")
    private CustomElement widgetTypeSelectorHeading;

    @FindBy(xpath = "//div[@class='widget-type-selector']//div[contains(@class, 'widget-type-item')]")
    private List<CustomRadioButton> widgetTypeItemList;

    @FindBy(xpath = "//div[contains(@class,'buttons-block')]/div")
    private CustomElement nextStepButton;

    public CustomRadioButton getWidget(String typeName) {
        return widgetTypeItemList.stream().filter(item -> item.getText().equals(typeName)).findFirst()
                .orElseThrow(() -> new NoSuchElementException(String.format("No widget type '%s' was found!", typeName)));
    }
}
