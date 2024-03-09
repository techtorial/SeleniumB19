package com.qa.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class BlazeMainPage {

    public BlazeMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@id='itemc']")
    List<WebElement> allCategories;
    @FindBy(css = "#cartur")
    WebElement cartButton;

    public void clickCartButton(){
        cartButton.click();
    }
    public void chooseCategory(String expectedCategory){
        for(WebElement category:allCategories){
            if(BrowserUtils.getText(category).contains(expectedCategory)){
                category.click();
                break;
            }
        }
    }
}
