package com.qa.Bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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





}
