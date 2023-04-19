package com.epam.biaseda.reportportaltest.ui.driver.drivertype;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum BrowserType {

    FIREFOX(DriverManagerType.FIREFOX),
    CHROME(DriverManagerType.CHROME),
    CHROME_HEADLESS(DriverManagerType.CHROME);

    private DriverManagerType driverManagerType;


    public static BrowserType parse(String type) {
        return Arrays.stream(values())
                .filter(browserType -> browserType.toString().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Unknown Browser Type '%s'. Supported values are: '%s'",
                        type, Arrays.toString(BrowserType.values()))));
    }
}
