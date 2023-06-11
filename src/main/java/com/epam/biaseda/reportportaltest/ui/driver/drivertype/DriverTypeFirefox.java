package com.epam.biaseda.reportportaltest.ui.driver.drivertype;

import com.epam.biaseda.reportportaltest.core.property.ApplicationProperty;
import com.epam.biaseda.reportportaltest.core.property.ApplicationPropertyService;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DriverTypeFirefox extends DriverType {

    public DriverTypeFirefox() {
        browserVersion = ApplicationPropertyService.getProperty(ApplicationProperty.WEBDRIVER_FIREFOX_VERSION);
    }

    /**
     * Sets Firefox specific settings
     */
    @Override
    public MutableCapabilities getCapabilities() {
        //'/dev/null' is a special file on UNIX systems,
        // which is a so-called "empty device".
        // Recording to it is successful, regardless of the amount of "recorded" information.
        // Reading from '/dev/null' is equivalent to reading the end of the file (EOF).
        System.setProperty("webdriver.firefox.logfile", "/dev/null");
        FirefoxProfile browserProfile = new FirefoxProfile();
        //list of MIME types to save to disk without asking what to use to open the file.
        // This setting is actually disabling download dialog box
        browserProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
        browserProfile.setPreference("browser.download.folderList", 2);
        //Disabling Download Manager window when a download begins
        browserProfile.setPreference("browser.download.manager.showWhenStarting", false);
        //Determines the directory to download, where download_dir is a path
        browserProfile.setPreference("browser.download.dir", downloadDir);
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(browserProfile);
        options.setPlatformName(platform);
        options.setBrowserVersion("113");
        options.setCapability("enableVNC", true);
        options.setCapability("enableVideo", true);
        return options;
    }

    @Override
    protected WebDriver getLocalWebDriver() {
        setupDriverManager(BrowserType.FIREFOX);
        FirefoxOptions firefoxOptions = (FirefoxOptions) getCapabilities();
        return new FirefoxDriver(firefoxOptions);
    }
}

