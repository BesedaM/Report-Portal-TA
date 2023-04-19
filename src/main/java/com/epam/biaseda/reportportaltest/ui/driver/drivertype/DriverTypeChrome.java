package com.epam.biaseda.reportportaltest.ui.driver.drivertype;

import com.epam.biaseda.reportportaltest.core.util.ApplicationProperty;
import com.epam.biaseda.reportportaltest.core.util.ApplicationPropertyService;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class DriverTypeChrome extends DriverType {

    private boolean isHeadless = false;

    public DriverTypeChrome(boolean isHeadless) {
        this.isHeadless = isHeadless;
        browserVersion = ApplicationPropertyService.getProperty(ApplicationProperty.WEBDRIVER_CHROME_VERSION);
    }

    @Override
    protected WebDriver getLocalWebDriver() {
        setupDriverManager(BrowserType.CHROME);
        ChromeOptions chromeOptions = (ChromeOptions) getCapabilities();
        return new ChromeDriver(chromeOptions);
    }

    /**
     * Manage Chrome specific settings in a way that chrome driver can understand
     */
    @Override
    public MutableCapabilities getCapabilities() {
        ChromeOptions options = new ChromeOptions();
        if (platform.equalsIgnoreCase("linux")) {
            options.addArguments("--headless", "window-size=1920,1080", "--no-sandbox");
            options.addArguments(new String[]{"--start-maximized"});
        } else {
            HashMap<String, Object> chromePrefs = new HashMap<>();
            //Disabling Popup blocker in Chrome
            chromePrefs.put("profile.default_content_settings.popups", 0);
            //Specify default download directory
            chromePrefs.put("download.default_directory", downloadDir);
            //Disable Chrome save password dialog pop up
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            //Suppress the download warning:
            //Chrome displays a modal warning dialog when an attempt is made to download the same file more than once from a web site)
            chromePrefs.put("profile.content_settings.pattern_pairs.*.multiple-automatic-downloads", 1);
            //enable auto download a file
            chromePrefs.put("download.prompt_for_download", false);
            options.addArguments(new String[]{"--service-type"});
            options.addArguments(new String[]{"--start-maximized"});
            options.addArguments(new String[]{"--disable-extensions"});
            options.addArguments(new String[]{"disable-infobars"});
            options.addArguments(new String[]{"--no-sandbox"});
            options.setAcceptInsecureCerts(true);
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--remote-allow-origins=*");
        }

        if (isHeadless) {
            options.addArguments("--headless");
        }

        options.setPlatformName(platform);

        return options;
    }
}
