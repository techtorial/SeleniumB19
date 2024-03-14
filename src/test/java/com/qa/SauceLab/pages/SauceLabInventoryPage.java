package com.qa.SauceLab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class SauceLabInventoryPage {

    public SauceLabInventoryPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".inventory_item_name ")
    List<WebElement> allItemsName;
    @FindBy(css = ".inventory_details_name")
    WebElement productName;
    @FindBy(css = ".inventory_details_desc")
    WebElement productDescription;
    @FindBy(css = ".inventory_details_price")
    WebElement productPrice;

public void chooseItem(String expectedItem){
    for(WebElement item:allItemsName){
        if(BrowserUtils.getText(item).contains(expectedItem)){
            item.click();
            break;
        }
    }
}
public void validateProductInformation(String productName,String productDescription,String productPrice) throws InterruptedException {
    Assert.assertEquals(BrowserUtils.getText(this.productName),productName);
    Thread.sleep(1000);
    Assert.assertTrue(BrowserUtils.getText(this.productDescription).contains(productDescription));
    Thread.sleep(1000);
    Assert.assertEquals(BrowserUtils.getText(this.productPrice),productPrice);
}








}
