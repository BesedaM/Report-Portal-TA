package com.epam.biaseda.reportportaltest.ui.page.addnewlightbox;

import com.epam.biaseda.reportportaltest.ui.page.addnewlightbox.widgetsetting.ProjectActivityPanelSettings;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class ProjectActivityPanelWidgetLightbox extends ConfigureWidgetLightbox {

    @FindBy(xpath = "//form")
    private ProjectActivityPanelSettings projectActivityPanelSettings;
}
