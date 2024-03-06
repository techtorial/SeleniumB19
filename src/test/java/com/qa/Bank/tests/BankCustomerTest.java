package com.qa.Bank.tests;

import com.qa.Bank.pages.BankCustomerPage;
import com.qa.Bank.pages.BankLoginPage;
import com.qa.Bank.pages.BankManagerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankCustomerTest {

    @Test
    public void validateCustomerTransactionFunctionality() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage bankLoginPage=new BankLoginPage(driver);
        bankLoginPage.clickManagerLoginButton();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.addCustomerInformation(driver,"Ahmet","Baldir","13123",
                "Customer added successfully");
        bankManagerPage.openAccountInformation(driver,"Ahmet Baldir","---Currency---",
                "Dollar","Pound","Rupee","Account created successfully");
        bankManagerPage.customerDataInformation("Ahmet","Baldir","13123");
        bankLoginPage.clickHomeButton();
        bankLoginPage.clickCustomerLoginButton();
        BankCustomerPage bankCustomerPage=new BankCustomerPage(driver);
        bankCustomerPage.loginWithCustomer("Ahmet Baldir");//you log in successfully
        bankCustomerPage.accountGeneralInformation("Welcome Ahmet Baldir !!","0","Dollar");
        bankCustomerPage.depositProcess("500","Deposit Successful","rgba(255, 0, 0, 1)");
        bankCustomerPage.withdrawalProcess("300","Transaction successful","rgba(255, 0, 0, 1)");
        bankCustomerPage.transactionProcess();

    }
}
