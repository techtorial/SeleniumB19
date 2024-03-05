package com.qa.Bank.tests;

import com.qa.Bank.pages.BankLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankLoginTest {

    @Test
    public void validateLoginInformation(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage bankLoginPage=new BankLoginPage(driver);
        bankLoginPage.loginPageInformation(driver,"XYZ Bank","XYZ Bank",
                "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }
}
