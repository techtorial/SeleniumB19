package com.qa.blaze.tests;

import com.qa.blaze.pages.BlazeLaptopsPage;
import com.qa.blaze.pages.BlazeLoginPage;
import com.qa.blaze.pages.BlazeMainPage;
import com.qa.blaze.pages.BlazeProductPage;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class BlazeOrderTest extends BlazeTestBase{

    @Test
    public void validateOrderFunctionality() throws InterruptedException {
        BlazeLoginPage blazeLoginPage=new BlazeLoginPage(driver);
        BlazeMainPage blazeMainPage=new BlazeMainPage(driver);
        BlazeLaptopsPage blazeLaptopsPage=new BlazeLaptopsPage(driver);
        BlazeProductPage blazeProductPage=new BlazeProductPage(driver);
        blazeLoginPage.loginFunctionality(ConfigReader.readProperty("blazeusername"),
                ConfigReader.readProperty("blazepassword"));
        blazeMainPage.chooseCategory("Laptops");
        blazeLaptopsPage.chooseProduct("MacBook Pro");
        blazeProductPage.productInformation(driver,"MacBook Pro",
                "$1100 *includes tax","Product added.");
    }
}
