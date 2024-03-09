package com.qa.blaze.tests;

import com.qa.blaze.pages.*;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class BlazeOrderTest extends BlazeTestBase{

    @Test
    public void validateOrderFunctionality() throws InterruptedException {
        BlazeLoginPage blazeLoginPage=new BlazeLoginPage(driver);
        BlazeMainPage blazeMainPage=new BlazeMainPage(driver);
        BlazeLaptopsPage blazeLaptopsPage=new BlazeLaptopsPage(driver);
        BlazeProductPage blazeProductPage=new BlazeProductPage(driver);
        BlazeOrderPage blazeOrderPage=new BlazeOrderPage(driver);
        blazeLoginPage.loginFunctionality(ConfigReader.readProperty("blazeusername"),
                ConfigReader.readProperty("blazepassword"));
        blazeMainPage.chooseCategory("Laptops");
        blazeLaptopsPage.chooseProduct("MacBook Pro");
        blazeProductPage.productInformation(driver,"MacBook Pro",
                "$1100 *includes tax","Product added.");
        blazeMainPage.clickCartButton();
        blazeOrderPage.orderFunctionality(driver,"Ahmet","USA","Chicago",
                ConfigReader.readProperty("creditcard"),"08","2025",
                "Thank you for your purchase!",
                "https://www.demoblaze.com/index.html");
    }
}
