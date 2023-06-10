package com.epam.biaseda.reportportaltest.ui.selenide.page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage {

    @FindBy(xpath = "//*[contains(@class, 'block-header')]")
    private SelenideElement welcomeMessage;
    @FindBy(xpath = "//*[contains(@class, 'externalLoginBlock')]/button")
    private SelenideElement externalLoginButton;
    @FindBy(xpath = "//input[@name='login']")
    private SelenideElement login;
    @FindBy(xpath = "//input[@name='password']")
    private SelenideElement password;
    @FindBy(xpath = "//button[@type='submit']")
    private SelenideElement submitButton;
}
