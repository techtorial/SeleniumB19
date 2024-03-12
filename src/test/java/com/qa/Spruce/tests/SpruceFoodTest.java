package com.qa.Spruce.tests;

import com.qa.Spruce.pages.SeaFoodPage;
import com.qa.Spruce.pages.SpruceMainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SpruceFoodTest extends SpruceTestBase{
    @Parameters({"searchKey","expectedMessage"})
    @Test
    public void validateSearchFunctionality(String searchKey,String expectedMessage){
        SpruceMainPage spruceMainPage=new SpruceMainPage(driver);
        SeaFoodPage seaFoodPage=new SeaFoodPage(driver);
        spruceMainPage.chooseCategory(driver);
        seaFoodPage.searchFunctionality(driver,searchKey,expectedMessage);
    }
}
