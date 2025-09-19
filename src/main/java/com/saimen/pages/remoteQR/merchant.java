package com.saimen.pages.remoteQR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.saimen.AbstractPage;

public class merchant extends AbstractPage {
    @FindBy(xpath = "//th[@class='sorting_asc']")
    private WebElement validator;
    @FindBy(xpath = "//input[@type='search']")
    private WebElement search;

    public merchant(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.validator));
        return this.validator.isDisplayed();
    }

    public void chooseMerchant(String mid) {
        search.sendKeys(mid);
        driver.findElement(By.xpath("//a[@href='/remoteqr/merchant/" + mid + "']")).click();
    }

}
