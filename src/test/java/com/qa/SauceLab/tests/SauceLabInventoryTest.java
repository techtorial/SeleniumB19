package com.qa.SauceLab.tests;

import com.qa.SauceLab.pages.SauceLabInventoryPage;
import com.qa.SauceLab.pages.SauceLabMainPage;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class SauceLabInventoryTest extends SauceLabTestBase{

    @Test(dataProvider = "productinformation",dataProviderClass = SauceLabData.class)
    public void validateItemInformation(String item,String productDescription,String price) throws InterruptedException {
        SauceLabMainPage sauceLabMainPage=new SauceLabMainPage(driver);
        SauceLabInventoryPage sauceLabInventoryPage=new SauceLabInventoryPage(driver);
        sauceLabMainPage.login(ConfigReader.readProperty("saucelabusername"),
                               ConfigReader.readProperty("saucelabpassword"));
        sauceLabInventoryPage.chooseItem(item);
        sauceLabInventoryPage.validateProductInformation(item,productDescription,price);
    }
}
