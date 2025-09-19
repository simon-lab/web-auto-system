package com.saimen.pages.remoteQR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.saimen.AbstractPage;

public class loginPage extends AbstractPage {

    @FindBy(xpath = "//a[.='DSPMain Dashboard']")
    private WebElement validator;
    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//span[@class='fas fa-lock']")
    private WebElement hiddenBtn;
    @FindBy(xpath = "//input[@id='remember']")
    private WebElement rememberMeBox;
    @FindBy(xpath = "//button[@name='signIn']")
    private WebElement signInBtn;

    public loginPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.validator));
        return this.validator.isDisplayed();
    }

    public void fillUsername(String userName) {
        usernameField.sendKeys(userName);
    }

    public void fillPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void signInClick() {
        signInBtn.click();
    }

}
