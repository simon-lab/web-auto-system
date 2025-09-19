package tests.remoteQR;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.saimen.pages.remoteQR.loginPage;
import com.saimen.pages.remoteQR.merchant;
import com.saimen.pages.remoteQR.merchantDesc;
import com.saimen.pages.remoteQR.oprHomePage;

import tests.remoteQR.model.qrMerchantTestData;
import util.JsonUtil;

public class RemoteQRTest {

    WebDriver driver;
    loginPage loginPage;
    merchant merchant;
    merchantDesc merchantDesc;
    oprHomePage oprHomePage;
    private qrMerchantTestData testData;

    @BeforeClass
    @Parameters({ "testDataPath" })
    public void setEnvironment(String testDataPath) {
        new File(testDataPath);
        this.testData = JsonUtil.getTestData(testDataPath, qrMerchantTestData.class);
        System.setProperty("webdriver.chrome.driver", "src/test/java/tests/driver/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();

        driver.get("https://uat.dspportal.local/");
        loginPage loginPage = new loginPage(driver);
        oprHomePage = new oprHomePage(driver);
        loginPage.isAt();
        loginPage.fillUsername("art");
        loginPage.fillPassword("123");
        loginPage.signInClick();
        oprHomePage.isAt();
        oprHomePage.merchantClick();
        merchant = new merchant(driver);

        merchant.isAt();
        merchant.chooseMerchant(testData.mid());
    }

    public void addNewTID(int repetisi) {
        merchantDesc = new merchantDesc(driver);
        merchantDesc.isAt();
        String city = merchantDesc.getCity();
        merchantDesc.clickNewTid();
        merchantDesc.popUpValidator();
        String tid = String.format("%02d", repetisi);
        merchantDesc.fillTid(tid);
        merchantDesc.fillUnikMID(testData.unikMid());
        merchantDesc.fillTerminalCity(city);
        merchantDesc.chooseTerminalProduct(testData.terminalProd());
        merchantDesc.fillTerminalChannel(testData.terminalChannel());
        merchantDesc.clickAddTerminal();

    }

    @Test
    public void mainProgram() throws InterruptedException {
        for (int i = 1; i <= testData.repetisi(); i++) {
            addNewTID(i);
            Thread.sleep(1000);
        }
    }

}
