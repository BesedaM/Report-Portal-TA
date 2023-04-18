package com.epam.biaseda.reportportaltest.core.driver;

import com.epam.biaseda.reportportaltest.core.driver.drivertype.BrowserType;
import com.epam.biaseda.reportportaltest.core.driver.drivertype.DriverType;
import com.epam.biaseda.reportportaltest.core.driver.drivertype.DriverTypeChrome;
import com.epam.biaseda.reportportaltest.core.driver.drivertype.DriverTypeFirefox;
import com.epam.biaseda.reportportaltest.core.util.ApplicationPropertyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

import static com.epam.biaseda.reportportaltest.core.util.ApplicationProperty.BROWSER_TYPE;


public class WebDriverFactory {

    private static final Logger log = LogManager.getRootLogger();

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
                throw new NoSuchElementException(String.format("Unsupported Browser Type specified at '%s' property: '%s'. Expected values are: '%s'",
                        BROWSER_TYPE, activeProfileBrowserTypeProperty, Arrays.toString(BrowserType.values())));
        }
    }

    public WebDriver instantiateWebDriver() {
        log.info("Current Browser Type Selected: {}", definedDriverType.getClass().getCanonicalName());
        WebDriver webdriver = definedDriverType.getWebDriverObject();
        webdriver.manage().window().maximize();
        webdriver.manage().window().setSize(BROWSER_WINDOW_DIMENSION);

        return webdriver;
    }
}


