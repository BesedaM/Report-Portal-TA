package com.epam.biaseda.reportportaltest.ui.util;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.ui.driver.WebDriverHolder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotTaker {

    private static final CustomLogger log = CustomLoggerProvider.getLogger();

    public static void takeScreenshot() throws IOException {
        File screenshot = ((TakesScreenshot) WebDriverHolder.getWebDriver()).getScreenshotAs(OutputType.FILE);

        String timeString = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss").format(LocalDateTime.now());
        String pathString = Paths.get("./target/screenshot/" + timeString + ".png").toAbsolutePath().toString();

        File newFile = new File(pathString);
        FileUtils.copyFile(screenshot, newFile);
        log.error(String.format("Screenshot %s saved", newFile.getPath()));
    }
}
