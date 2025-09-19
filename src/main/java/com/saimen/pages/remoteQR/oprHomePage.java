package com.saimen.pages.remoteQR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.saimen.AbstractPage;

public class oprHomePage extends AbstractPage {
    @FindBy(xpath = "//span[@class='brand-text font-weight-light']")
    private WebElement validator;
    @FindBy(xpath = "//h4[text()='Approval Request']")
    private WebElement approvalPopUpValidator;
    @FindBy(xpath = "//div[@class='swal2-icon swal2-success swal2-icon-show']")
    private WebElement approveValidator;
    @FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
    private WebElement closeBtn;

    @FindBy(xpath = "//a[@href='/remoteqr/merchant']")
    private WebElement merchantQRBtn;

    public oprHomePage(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.validator));
        return this.validator.isDisplayed();
    }

    public void merchantClick() {
        merchantQRBtn.click();
    }

}
