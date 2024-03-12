package com.qa.Spruce.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class SeaFoodPage {

    public SeaFoodPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#search-form-input")
    WebElement searchBar;
    @FindBy(xpath = "//label[@for='starRating_score_4Star']")
    WebElement rating;
    @FindBy(xpath = "//label[@for='pop_search_editor']")
    WebElement editorChoice;
    @FindBy(xpath = "//h4[@class='card__title']")
    WebElement productName;

    public void searchFunctionality(WebDriver driver,String searchKey,String expectedName){
        BrowserUtils.scrollIntoView(driver,searchBar);
        searchBar.sendKeys(searchKey, Keys.ENTER);
        rating.click();
        editorChoice.click();
        Assert.assertEquals(BrowserUtils.getText(productName),expectedName);
    }

}
