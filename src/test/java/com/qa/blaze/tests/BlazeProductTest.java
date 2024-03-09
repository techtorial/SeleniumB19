package com.qa.blaze.tests;

import com.qa.blaze.pages.BlazeLaptopsPage;
import com.qa.blaze.pages.BlazeMainPage;
import com.qa.blaze.pages.BlazeProductPage;
import org.testng.annotations.Test;

public class BlazeProductTest extends BlazeTestBase{

    @Test
    public void validateProductInformation() throws InterruptedException {
        BlazeMainPage blazeMainPage=new BlazeMainPage(driver);
        BlazeLaptopsPage blazeLaptopsPage=new BlazeLaptopsPage(driver);
        BlazeProductPage blazeProductPage=new BlazeProductPage(driver);
        blazeMainPage.chooseCategory("Laptops");
        blazeLaptopsPage.chooseProduct("MacBook Pro");
        blazeProductPage.productInformation(driver,"MacBook Pro",
                "$1100 *includes tax","Product added");
    }
}
