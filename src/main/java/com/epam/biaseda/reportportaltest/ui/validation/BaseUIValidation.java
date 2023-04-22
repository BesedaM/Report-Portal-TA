package com.epam.biaseda.reportportaltest.ui.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.assertj.core.description.Description;

import java.util.function.Consumer;

public class BaseUIValidation {

    protected static final String VALIDATE_TEXT_PATTERN = "%s text";
    protected static final String VALIDATE_PRESENCE_PATTERN = "%s present";

    protected static final Logger log = LogManager.getRootLogger();

    protected static StringBuilder createDescriptionReportBuilder() {
        StringBuilder descriptionReportBuilder = new StringBuilder(String.format("Assertions:%n"));
        Consumer<Description> descriptionConsumer = desc -> descriptionReportBuilder.append(String.format("-- %s%n", desc));

        Assertions.setDescriptionConsumer(descriptionConsumer);
        return descriptionReportBuilder;
    }
}
