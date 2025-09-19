package com.saimen.pages.remoteQR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.saimen.AbstractPage;

public class merchantDesc extends AbstractPage {
    @FindBy(xpath = "//h4[text()='Merchant List']")
    private WebElement validator;
    @FindBy(xpath = "//div[@id='add-user-partner']")
    private WebElement popUpValidator;

    @FindBy(xpath = "(//div[@class='col-md-9'])[5]")
    private WebElement city;
    @FindBy(xpath = "//button[@data-target='#add-user-partner']")
    private WebElement addTidBtn;

    @FindBy(xpath = "//input[@id='tid']")
    private WebElement tidField;
    @FindBy(xpath = "//input[@id='edc_id']")
    private WebElement unikMIDField;
    @FindBy(xpath = "//input[@id='terminal_city']")
    private WebElement terminalCityField;

    @FindBy(xpath = "//select[@id='terminal_product']")
    private WebElement terminalProd;

    @FindBy(xpath = "//input[@id='terminal_channel']")
    private WebElement terminalChannel;

    @FindBy(xpath = "//button[@id='addTid']")
    private WebElement addTerminalBtn;

    public merchantDesc(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.validator));
        this.wait.until(ExpectedConditions.invisibilityOf(popUpValidator));
        return this.validator.isDisplayed();
    }

    public String getCity() {
        return city.getText();
    }

    public void popUpValidator() {
        this.wait.until(ExpectedConditions.visibilityOf(popUpValidator));

    }

    public void clickNewTid() {
        addTidBtn.click();

    }

    public void fillTid(String keberapa) {
        tidField.sendKeys("A" + keberapa);

    }

    public void fillUnikMID(String inputUnikMID) {
        unikMIDField.sendKeys(inputUnikMID);

    }

    public void fillTerminalCity(String inputTerminalCity) {
        terminalCityField.sendKeys(inputTerminalCity);

    }

    public void chooseTerminalProduct(String inputTerminalProduction) {
        Select terminalSelect = new Select(terminalProd);
        if (inputTerminalProduction.equalsIgnoreCase("ECOMMERCE")) {
            terminalSelect.selectByValue("ECOMMERCE");
        } else if (inputTerminalProduction.equalsIgnoreCase("NUPAY")) {
            terminalSelect.selectByValue("NUPAY");
        } else if (inputTerminalProduction.equalsIgnoreCase("VKIOSK")) {
            terminalSelect.selectByValue("VKIOSK");
        } else if (inputTerminalProduction.equalsIgnoreCase("KIOSK")) {
            terminalSelect.selectByValue("KIOSK");
        } else if (inputTerminalProduction.equalsIgnoreCase("SELF CHECKOUT")) {
            terminalSelect.selectByValue("SELF CHECKOUT");
        } else if (inputTerminalProduction.equalsIgnoreCase("BILLPAYMENT")) {
            terminalSelect.selectByValue("BILLPAYMENT");
        } else {
            System.out.println("Terminal Product Tidak Ada");
        }

    }

    public void fillTerminalChannel(String inputTerminalChannel) {
        terminalChannel.sendKeys(inputTerminalChannel);

    }

    public void clickAddTerminal() {
        addTerminalBtn.click();

    }

}
