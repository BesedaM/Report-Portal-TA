package com.epam.biaseda.reportportaltest.ui.driver.drivertype;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.core.property.ApplicationProperty;
import com.epam.biaseda.reportportaltest.core.property.ApplicationPropertyService;
import com.google.common.base.Strings;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

import static com.epam.biaseda.reportportaltest.core.property.ApplicationProperty.WEBDRIVER_MODE;

public abstract class DriverType {

    private static CustomLogger log = CustomLoggerProvider.getLogger();

    protected String platform;
    protected String browser;
    protected String browserVersion;
    protected String downloadDir;
    private DriverMode driverMode;

    enum DriverMode {
        LOCAL, REMOTE;

        public static DriverMode fromValue(String value) {
            return Arrays.stream(values())
                    .filter(item -> item.toString().equalsIgnoreCase(value))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(String.format("Unknown Driver Mode '%s'!", value)));
        }
    }

    public WebDriver getWebDriverObject() {
        readProperties();
        printDriverInfo();

        switch (driverMode) {
            case LOCAL:
                return getLocalWebDriver();
            case REMOTE:
                return getRemoteWebDriver();
            default:
                throw new IllegalStateException(String.format("Unknown Driver Mode '%s' used!", driverMode));
        }
    }

    private String fetchProperty(ApplicationProperty property) {
        String propertyValue = ApplicationPropertyService.getProperty(property);
        if (Strings.isNullOrEmpty(propertyValue)) {
            log.warn(String.format("'%s' property was not specified in config.properties file!", property));
        }
        return propertyValue;
    }

    private void readProperties() {
        String driverModeStr = ApplicationPropertyService.getProperty(WEBDRIVER_MODE);
        driverMode = Strings.isNullOrEmpty(driverModeStr)
                ? DriverMode.REMOTE
                : DriverMode.fromValue(driverModeStr);

        platform = fetchProperty(ApplicationProperty.PLATFORM);
        browser = fetchProperty(ApplicationProperty.BROWSER_TYPE);
        downloadDir = fetchProperty(ApplicationProperty.BROWSER_DOWNLOAD_DIR);
    }

    protected void printDriverInfo() {
        log.info(String.format("WebDriver Mode: %s", driverMode));
        log.info(String.format("Platform: %s", platform));
        log.info(String.format("Browser: %s", browser));
    }

    protected abstract MutableCapabilities getCapabilities();

    protected abstract WebDriver getLocalWebDriver();

    protected void setupDriverManager(BrowserType browserType) {
        try {
            WebDriverManager.getInstance(browserType.getDriverManagerType()).driverVersion(browserVersion).setup();
        } catch (WebDriverManagerException ex) {
            log.warn("There was an error managing wires, chrome... trying again forcing to use cache, or mirror");
            WebDriverManager.getInstance(browserType.getDriverManagerType()).useMirror().setup();
        }
    }

    private WebDriver getRemoteWebDriver() {
        throw new UnsupportedOperationException("Remote Webriver is not supported by test framework. Please, introduce required changes");
    }
}

