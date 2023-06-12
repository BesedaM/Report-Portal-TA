package com.epam.biaseda.reportportaltest.ui.driver;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.core.property.ApplicationPropertyService;
import com.epam.biaseda.reportportaltest.ui.driver.drivertype.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

import static com.epam.biaseda.reportportaltest.core.property.ApplicationProperty.BROWSER_TYPE;


public class WebDriverFactory {

    private static final Dimension BROWSER_WINDOW_DIMENSION;

    private static DriverType definedDriverType;

    static {
        BROWSER_WINDOW_DIMENSION = new Dimension(1920, 1080);
    }

    public WebDriver getDriver(String browserName) {
        if (null == WebDriverHolder.getWebDriver()) {
            definedDriverType = defineDriverType(browserName);
            return instantiateWebDriver();
        } else return WebDriverHolder.getWebDriver();
    }

    public DriverType defineDriverType(String browserName) {
        String activeProfileBrowserTypeProperty = browserName != null ?
                browserName : ApplicationPropertyService.getProperty(BROWSER_TYPE);
        switch (BrowserType.parse(activeProfileBrowserTypeProperty)) {
            case FIREFOX:
                return new DriverTypeFirefox();

            case CHROME:
                return new DriverTypeChrome(false);

            case CHROME_HEADLESS:
                return new DriverTypeChrome(true);

            case EDGE:
                return new DriverTypeEdge();

            default:
                throw new IllegalStateException(String.format("Unsupported Browser Type specified at '%s' property: '%s'. Expected values are: '%s'",
                        BROWSER_TYPE, activeProfileBrowserTypeProperty, Arrays.toString(BrowserType.values())));
        }
    }

    public WebDriver instantiateWebDriver() {
        WebDriver webdriver = definedDriverType.getWebDriverObject();
        webdriver.manage().window().maximize();
        webdriver.manage().window().setSize(BROWSER_WINDOW_DIMENSION);

        return webdriver;
    }
}


