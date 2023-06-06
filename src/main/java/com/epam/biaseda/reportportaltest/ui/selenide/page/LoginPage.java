package com.epam.biaseda.reportportaltest.ui.selenide.page;

import org.openqa.selenium.By;

public class LoginPage {

    public static final By WELCOME_MESSAGE = By.xpath("//*[contains(@class, 'block-header')]");
    public static final By EXTERNAL_LOGIN_BUTTON = By.xpath("//*[contains(@class, 'externalLoginBlock')]/button");
    public static final By LOGIN = By.xpath("//input[@name='login']");
    public static final By PASSWORD = By.xpath("//input[@name='password']");
    public static final By SUBMIT_BUTTON = By.xpath("//button[@type='submit']");
}
