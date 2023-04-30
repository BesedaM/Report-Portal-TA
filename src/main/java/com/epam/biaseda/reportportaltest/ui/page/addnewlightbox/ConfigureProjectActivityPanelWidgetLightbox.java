package com.epam.biaseda.reportportaltest.ui.page.addnewlightbox;

import com.epam.biaseda.reportportaltest.ui.page.addnewlightbox.widgetsetting.LaunchStatisticsChartSettings;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class ConfigureProjectActivityPanelWidgetLightbox extends ConfigureWidgetLightbox {

    @FindBy(xpath = "//form")
    private LaunchStatisticsChartSettings launchStatisticsChartSettings;

}
