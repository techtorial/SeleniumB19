package com.qa.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BlazeLoginPage {

    public BlazeLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#signin2")
    WebElement signUpButton;
    @FindBy(css = "#sign-username")
    WebElement signUpUsername;
    @FindBy(css = "#sign-password")
    WebElement signUpPassword;
    @FindBy(xpath = "//button[.='Sign up']")
    WebElement signUpSubmitButton;
    @FindBy(css = "#login2")
    WebElement loginButton;
    @FindBy(css = "#loginusername")
    WebElement loginUsername;
    @FindBy(css = "#loginpassword")
    WebElement loginPassword;
    @FindBy(xpath = "//button[contains(@onclick,'logIn')]")
    WebElement loginSubmitButton;
    @FindBy(css = "#nameofuser")
    WebElement welcomeUser;


    public void signUpFunctionality(WebDriver driver,String username,String password,
                                    String expectedMessage) throws InterruptedException {
        signUpButton.click();
        signUpUsername.sendKeys(username);
        signUpPassword.sendKeys(password);
        signUpSubmitButton.click();
        Thread.sleep(1000);
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(),expectedMessage);
        alert.accept();
    }

    public void loginFunctionality(String username,String password) throws InterruptedException {
        loginButton.click();
        loginUsername.sendKeys(username);
        loginPassword.sendKeys(password);
        Thread.sleep(1000);
        loginSubmitButton.click();
        Thread.sleep(1000);
        Assert.assertTrue(welcomeUser.isDisplayed());
    }




    /*
1-Create LoginPage
2-Click Sign up Button and provide username and password from ConfigReader
3-validate the message "Sign up successful." and click Ok Button
4-Click Login Button and Login Successfully
5-Validate Welcomeusername is visible
6-Run your test and make sure it is passing.
NOTE:You should have 2 methods under LoginPage
  *One for SignUp functioanlity
  *One for Login Functionality
*/
}
