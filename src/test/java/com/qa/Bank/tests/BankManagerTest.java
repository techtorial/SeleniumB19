package com.qa.Bank.tests;

import com.qa.Bank.pages.BankLoginPage;
import com.qa.Bank.pages.BankManagerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankManagerTest {

    @Test
    public void validateAddCustomerFunctionality(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage bankLoginPage=new BankLoginPage(driver);
        bankLoginPage.clickManagerLoginButton();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.addCustomerInformation(driver,"Ahmet","Baldir","13123",
                "Customer added successfully");
    }


}
