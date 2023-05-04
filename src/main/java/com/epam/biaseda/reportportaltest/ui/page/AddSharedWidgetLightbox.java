package com.epam.biaseda.reportportaltest.ui.page;

import com.epam.biaseda.reportportaltest.ui.page.block.SharedWidgetListItem;
import com.epam.biaseda.reportportaltest.ui.page.block.WizardInfoSection;
import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddSharedWidgetLightbox extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'modal-header-content')]")
    private CustomElement header;

    @FindBy(xpath = "//div[contains(@class, 'close-modal-icon')]")
    private CustomElement closeLightboxButton;

    @FindBy(xpath = "//div[contains(@class,'shared-widget-info-section')]")
    private WizardInfoSection wizardInfoSection;

    @FindBy(xpath = "//div[contains(@class, 'shared-widgets-list-section')]/h1")
    private CustomElement selectSharedWidgetTitle;

    @FindBy(xpath="//div[contains(@class, 'input-search')]")
    private CustomElement widgetSearch;

    @FindBy(xpath = "//div[contains(@class, 'widget-list-item')]")
    private List<SharedWidgetListItem> sharedWidgetList;

    @FindBy(xpath = "//div[contains(@class, 'button-container')][1]/button")
    private CustomElement cancelButton;

    @FindBy(xpath = "//div[contains(@class, 'button-container')][2]/button")
    private CustomElement addButton;
}
