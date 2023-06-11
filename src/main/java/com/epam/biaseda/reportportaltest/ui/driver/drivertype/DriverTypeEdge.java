package com.epam.biaseda.reportportaltest.ui.driver.drivertype;

import com.epam.biaseda.reportportaltest.core.property.ApplicationProperty;
import com.epam.biaseda.reportportaltest.core.property.ApplicationPropertyService;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverTypeEdge extends DriverType {

    public DriverTypeEdge(){
        browserVersion = ApplicationPropertyService.getProperty(ApplicationProperty.WEBDRIVER_EDGE_VERSION);
    }

    @Override
    protected MutableCapabilities getCapabilities() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPlatformName(platform);
        edgeOptions.setBrowserVersion("113.0");
        edgeOptions.setCapability("enableVNC", true);
        edgeOptions.setCapability("enableVideo", true);
        return edgeOptions;
    }

    @Override
    protected WebDriver getLocalWebDriver() {
        setupDriverManager(BrowserType.EDGE);
        EdgeOptions edgeOptions = (EdgeOptions) getCapabilities();
        return new EdgeDriver(edgeOptions);
    }
}
