package com.qa.SauceLab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class SauceLabMainPage {

    public SauceLabMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#user-name")
    WebElement username;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(css = "#login-button")
    WebElement loginButton;
    @FindBy(tagName = "h3")
    WebElement errorMessage;

    public void login(String username,String password){
       this.username.sendKeys(username);
       this.password.sendKeys(password);
       loginButton.click();
    }
    public void errorMessage(String expectedMessage){
        Assert.assertEquals(BrowserUtils.getText(errorMessage),expectedMessage);
    }













}
