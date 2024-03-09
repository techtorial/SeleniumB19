package com.qa.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class BlazeProductPage {

    public BlazeProductPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(tagName = "h2")
    WebElement header;
    @FindBy(tagName = "h3")
    WebElement price;
    @FindBy(xpath = "//div[@id='more-information']")
    WebElement description;
    @FindBy(xpath = "//a[.='Add to cart']")
    WebElement addToCardButton;

    public void productInformation(WebDriver driver,String expectedHeader,String expectedPrice,String expectedMessage) throws InterruptedException {
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Assert.assertEquals(BrowserUtils.getText(price),expectedPrice);
        Assert.assertTrue(BrowserUtils.getText(description).contains(expectedHeader));
        addToCardButton.click();
        Thread.sleep(1000);
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),expectedMessage);
        alert.accept();
    }
}
