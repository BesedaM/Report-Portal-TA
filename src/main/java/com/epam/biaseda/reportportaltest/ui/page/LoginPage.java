package com.epam.biaseda.reportportaltest.ui.page;

import com.epam.biaseda.reportportaltest.ui.page.element.CustomElement;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class, 'block-header')]")
    private CustomElement welcomeMessage;

    @FindBy(xpath = "//*[contains(@class, 'externalLoginBlock')]/button")
    private CustomElement externalLoginButton;

    @FindBy(xpath = "//input[@name='login']")
    private CustomElement login;

    @FindBy(xpath = "//input[@name='password']")
    private CustomElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private CustomElement submit;
}
