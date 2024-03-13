package com.qa.SauceLab.tests;

import com.qa.SauceLab.pages.SauceLabMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceLabLoginTest extends SauceLabTestBase{

    @Test(dataProvider = "happyPath",dataProviderClass = SauceLabData.class)
    public void validateHappyPath(String username,String password,String expectedUrl,
                                  String expectedTitle){
        SauceLabMainPage sauceLabMainPage=new SauceLabMainPage(driver);
        sauceLabMainPage.login(username,password);
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }

    @Test(dataProvider = "negativePath",dataProviderClass = SauceLabData.class)
    public void validateNegativeScenarios(String username,String password,String expectedMessage){
        SauceLabMainPage sauceLabMainPage=new SauceLabMainPage(driver);
        sauceLabMainPage.login(username,password);
        sauceLabMainPage.errorMessage(expectedMessage);
    }
}
