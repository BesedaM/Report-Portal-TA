package com.epam.biaseda.reportportaltest.ui.validation;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import org.assertj.core.api.Assertions;
import org.assertj.core.description.Description;

import java.util.function.Consumer;

public class BaseUIValidation {

    protected static final String VALIDATE_TEXT_PATTERN = "%s text";
    protected static final String VALIDATE_PRESENCE_PATTERN = "%s is present";
    protected static final String VALIDATE_DROPDOWN_TEXT_PATTERN = "'%s' text is present in dropdown";

    protected static CustomLogger log = CustomLoggerProvider.getLogger();

    protected static StringBuilder createDescriptionReportBuilder() {
        StringBuilder descriptionReportBuilder = new StringBuilder(String.format("Assertions:%n"));
        Consumer<Description> descriptionConsumer = desc -> descriptionReportBuilder.append(String.format("-- %s%n", desc));

        Assertions.setDescriptionConsumer(descriptionConsumer);
        return descriptionReportBuilder;
    }
}
