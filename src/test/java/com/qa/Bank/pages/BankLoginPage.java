package com.qa.Bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class BankLoginPage {

    public BankLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//strong")
    WebElement header;
    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLoginButton;
    @FindBy(xpath = "//button[.='Bank Manager Login']")
    WebElement managerLoginButton;
    @FindBy(xpath = "//button[.='Home']")
    WebElement homeButton;

    public void loginPageInformation(WebDriver driver,String expectedHeader,String expectedTitle,String expectedUrl){
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Assert.assertTrue(customerLoginButton.isDisplayed() && customerLoginButton.isEnabled());
        Assert.assertTrue(managerLoginButton.isDisplayed() && managerLoginButton.isEnabled());
        Assert.assertTrue(homeButton.isDisplayed() && homeButton.isEnabled());
        Assert.assertEquals(driver.getTitle(),expectedTitle);
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }


}
