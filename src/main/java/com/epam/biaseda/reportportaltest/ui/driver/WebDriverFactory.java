package com.epam.biaseda.reportportaltest.ui.driver;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.core.property.ApplicationPropertyService;
import com.epam.biaseda.reportportaltest.ui.driver.drivertype.BrowserType;
import com.epam.biaseda.reportportaltest.ui.driver.drivertype.DriverType;
import com.epam.biaseda.reportportaltest.ui.driver.drivertype.DriverTypeChrome;
import com.epam.biaseda.reportportaltest.ui.driver.drivertype.DriverTypeFirefox;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

import static com.epam.biaseda.reportportaltest.core.property.ApplicationProperty.BROWSER_TYPE;


public class WebDriverFactory {

    private static CustomLogger log = CustomLoggerProvider.getLogger();

    private static final Dimension BROWSER_WINDOW_DIMENSION;

    private static DriverType definedDriverType;

    static {
        BROWSER_WINDOW_DIMENSION = new Dimension(1920, 1080);
    }

    public WebDriver getDriver() {
        if (null == WebDriverHolder.getWebDriver()) {
            definedDriverType = defineDriverType();
            return instantiateWebDriver();
        } else return WebDriverHolder.getWebDriver();
    }

    public DriverType defineDriverType() {
        String activeProfileBrowserTypeProperty = ApplicationPropertyService.getProperty(BROWSER_TYPE);
        switch (BrowserType.parse(activeProfileBrowserTypeProperty)) {
            case FIREFOX:
                return new DriverTypeFirefox();

            case CHROME:
                return new DriverTypeChrome(false);

            default:
                throw new IllegalStateException(String.format("Unsupported Browser Type specified at '%s' property: '%s'. Expected values are: '%s'",
                        BROWSER_TYPE, activeProfileBrowserTypeProperty, Arrays.toString(BrowserType.values())));
        }
    }

    public WebDriver instantiateWebDriver() {
        log.info(String.format("Current Browser Type Selected: %s", definedDriverType.getClass().getCanonicalName()));
        WebDriver webdriver = definedDriverType.getWebDriverObject();
        webdriver.manage().window().maximize();
        webdriver.manage().window().setSize(BROWSER_WINDOW_DIMENSION);

        return webdriver;
    }
}


