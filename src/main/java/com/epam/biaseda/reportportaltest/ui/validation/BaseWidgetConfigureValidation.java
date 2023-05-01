package com.epam.biaseda.reportportaltest.ui.validation;

import com.epam.biaseda.reportportaltest.ui.page.addnewlightbox.LaunchStatisticsChartWidgetLightbox;
import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseWidgetConfigureValidation extends BaseUIValidation{

    protected static void verifyCriteriaForWidgetDropdownMenu(List<CustomElement> dropdownOptions, String dropdownMenu) {
        log.debug("Verify Criteria for widget dropdown menu...");
        StringBuilder descriptionReportBuilder = createDescriptionReportBuilder();

        List<String> optionNames = dropdownOptions.stream().map(HtmlElement::getText).collect(Collectors.toList());
        assertThat(optionNames)
                .as(String.format(String.format(VALIDATE_DROPDOWN_TEXT_PATTERN, dropdownMenu))).contains(dropdownMenu);

        log.debug(descriptionReportBuilder.toString());
    }
}
