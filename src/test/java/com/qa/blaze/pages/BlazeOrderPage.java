package com.qa.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class BlazeOrderPage {

    public BlazeOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrderButton;
    @FindBy(css = "#name")
    WebElement name;
    @FindBy(css = "#country")
    WebElement country;
    @FindBy(css = "#city")
    WebElement city;
    @FindBy(css = "#card")
    WebElement creditCard;
    @FindBy(css = "#month")
    WebElement month;
    @FindBy(css = "#year")
    WebElement year;
    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseButton;
    @FindBy(xpath = "//div[contains(@class,'sweet-alert')]//h2")
    WebElement message;
    @FindBy(xpath = "//div[@class='sa-confirm-button-container']//button")
    WebElement okButton;

    public void orderFunctionality(WebDriver driver,String name,String county,String city,
                                   String card,String month,String year,
                                   String expectedMessage,String expectedUrl) throws InterruptedException {
        placeOrderButton.click();
        this.name.sendKeys(name);
        this.country.sendKeys(county);
        this.city.sendKeys(city);
        this.creditCard.sendKeys(card);
        this.month.sendKeys(month);
        this.year.sendKeys(year);
        Thread.sleep(1000);
        purchaseButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(message),expectedMessage);
        Thread.sleep(1000);
        okButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }

    /*
1-Create OrderPage
2-Click cart button(main page)
3-Click Placer Order
4-Fill all the blanks but "Credit Cart" should come from ConfigReader
5-Validate "Thank you for your purchase!"
6-Click OK button
7-Validate the url "https://www.demoblaze.com/index.html"
*/
}
