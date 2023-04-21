package com.epam.biaseda.reportportaltest.core.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationProperty {

    BROWSER_TYPE ("webdriver.browser"),
    WEBDRIVER_CHROME_VERSION("webdriver.chrome.version"),
    WEBDRIVER_FIREFOX_VERSION("webdriver.firefox.version"),
    WEBDRIVER_MODE("webdriver.mode"),
    WEBDRIVER_TIMEOUT_WAIT("webdriver.timeout.wait"),
    PLATFORM("webdriver.platform"),
    BROWSER_DOWNLOAD_DIR ("webdriver.browser.download.dir"),
    SERVER_TYPE("server.type"),
    PROJECT_NAME("project.name");

    private String name;
}
