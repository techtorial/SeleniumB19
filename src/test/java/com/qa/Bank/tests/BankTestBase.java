package com.qa.Bank.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverHelper;

import java.time.Duration;

public class BankTestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setup(){
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("bankurl"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
