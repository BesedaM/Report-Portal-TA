package com.epam.biaseda.reportportaltest.core.property;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationProperty {

    BROWSER_TYPE ("webdriver.browser"),
    WEBDRIVER_CHROME_VERSION("webdriver.chrome.version"),
    WEBDRIVER_FIREFOX_VERSION("webdriver.firefox.version"),
    BROWSER_EDGE_VERSION("browser.edge.version"),
    BROWSER_CHROME_VERSION("browser.chrome.version"),
    BROWSER_FIREFOX_VERSION("browser.firefox.version"),
    WEBDRIVER_EDGE_VERSION("webdriver.edge.version"),
    WEBDRIVER_MODE("webdriver.mode"),
    WEBDRIVER_TIMEOUT_WAIT("webdriver.timeout.wait"),
    WEBDRIVER_REMOTE_HUB_URL ( "webdriver.remote.hub.url"),
    PLATFORM("webdriver.platform"),
    BROWSER_DOWNLOAD_DIR ("webdriver.browser.download.dir"),
    SERVER_TYPE("server.type"),
    PROJECT_NAME("project.name");

    private String name;
}
