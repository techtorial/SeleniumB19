package com.qa.Bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class BankCustomerPage {

    public BankCustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#userSelect")
    WebElement customerName;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement welcomeMessage;
    @FindBy(xpath = "//strong[@class='ng-binding'][2]")
    WebElement balance;
    @FindBy(xpath = "//strong[@class='ng-binding'][3]")
    WebElement currency;
    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement depositButton;
    @FindBy(tagName = "input")
    WebElement amount;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitAmount;
    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement confirmationMessage;
    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement withdrawButton;
    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    WebElement transactionButton;
    @FindBy(xpath = "//tr[@id='anchor0']//td[2]")
    WebElement firstTransaction;
    @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
    WebElement secondTransaction;

    public void loginWithCustomer(String customerName){
        BrowserUtils.selectBy(this.customerName,customerName,"text");
        loginButton.click();
    }
    public void accountGeneralInformation(String expectedMessage,String expectedBalance,
                                          String expectedCurrency){
        Assert.assertEquals(BrowserUtils.getText(welcomeMessage),expectedMessage);
        Assert.assertEquals(BrowserUtils.getText(balance),expectedBalance);
        Assert.assertEquals(BrowserUtils.getText(currency),expectedCurrency);
    }
    public void depositProcess(String depositAmount,String expectedMessage,String expectedColor){
        depositButton.click();
        amount.sendKeys(depositAmount);
        submitAmount.click();
        Assert.assertEquals(BrowserUtils.getText(confirmationMessage),expectedMessage);
        Assert.assertEquals(confirmationMessage.getCssValue("color"),expectedColor);
    }
    public void withdrawalProcess(String withdrawAmount,String expectedMessage,String expectedColor) throws InterruptedException {
        Thread.sleep(1000);
        withdrawButton.click();
        Thread.sleep(1000);
        amount.sendKeys(withdrawAmount);
        submitAmount.click();
        Assert.assertEquals(BrowserUtils.getText(confirmationMessage),expectedMessage);
        Assert.assertEquals(confirmationMessage.getCssValue("color"),expectedColor);
    }
    public void transactionProcess() throws InterruptedException {
        int expectedBalance=Integer.parseInt(BrowserUtils.getText(balance));
        Thread.sleep(3000);
        transactionButton.click();
        Thread.sleep(3000);
        int actualBalance=Integer.parseInt(BrowserUtils.getText(firstTransaction)) -
                          Integer.parseInt(BrowserUtils.getText(secondTransaction));
        Assert.assertEquals(actualBalance,expectedBalance);
    }



}
