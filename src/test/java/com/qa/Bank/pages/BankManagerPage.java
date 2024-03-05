package com.qa.Bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class BankManagerPage {

    public BankManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(@ng-click,'addCust')]")
    WebElement addCustomerButton;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement zipCode;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitCustomer;
    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement openAccountButton;
    @FindBy(css = "#userSelect")
    WebElement customerName;
    @FindBy(css = "#currency")
    WebElement currency;
    @FindBy(xpath = "//button[.='Process']")
    WebElement processButton;

    public void addCustomerInformation(WebDriver driver,String firstName,String lastName,String zipCode,
    String expectedMessage){
        addCustomerButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.zipCode.sendKeys(zipCode);
        submitCustomer.submit();
        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();
    }

    public void openAccountInformation(WebDriver driver,String customerName,String option1,String option2,String option3,String option4,
                                       String expectedMessage){
        openAccountButton.click();
        BrowserUtils.selectBy(this.customerName,customerName,"text");//Ahmet Baldir
        Select currencyBox=new Select(currency);
        List<WebElement> actualCurrencies=currencyBox.getOptions();//4 options
        List<String> expectedCurrencies= Arrays.asList(option1,option2,option3,option4);

        for(int i=0;i<actualCurrencies.size();i++){ //you validates all options from currency
            Assert.assertEquals(BrowserUtils.getText(actualCurrencies.get(i)),expectedCurrencies.get(i));
        }
        BrowserUtils.selectBy(currency,option2,"value");//you choose Dollar
        processButton.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();
    }






}
