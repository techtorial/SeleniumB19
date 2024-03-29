package com.qa.SauceLab.tests;

import org.testng.annotations.DataProvider;

public class SauceLabData {

 @DataProvider(name = "happyPath")
    public Object[][] getPositiveData(){
     return new Object[][]{
             {"standard_user","secret_sauce","https://www.saucedemo.com/inventory.html","Swag Labs"},
             {"problem_user","secret_sauce","https://www.saucedemo.com/inventory.html","Swag Labs"},
             {"performance_glitch_user","secret_sauce","https://www.saucedemo.com/inventory.html","Swag Labs"},
             {"error_user","secret_sauce","https://www.saucedemo.com/inventory.html","Swag Labs"},
             {"visual_user","secret_sauce","https://www.saucedemo.com/inventory.html","Swag Labs"}
     };
 }
    @DataProvider(name = "negativePath")
    public Object[][] getNegativeData(){
        return new Object[][]{
                {"standard_user","dfsdgsf434","Epic sadface: Username and password do not match any user in this service"},
                {"standart_user","","Epic sadface: Password is required"},
                {"","sdfsdf434","Epic sadface: Username is required"},
                {"","","Epic sadface: Username is required"},
                {"locked_out_user","secret_sauce","Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @DataProvider(name="productinformation")
    public Object[][] getProductData(){
     return new Object[][]{
             {"Sauce Labs Backpack", "Sly Pack", "$29.99"},
             {"Sauce Labs Bike Light", "3 lighting modes", "$9.99"},
             {"Sauce Labs Bolt T-Shirt", "superhero on with ", "$15.99"},
             {"Sauce Labs Fleece Jacket", "quarter-zip fleece jacket", "$49.99"},
             {"Sauce Labs Onesie", "3-snap bottom", "$7.99"},
             {"Test.allTheThings() T-Shirt (Red)", "when cozying", "$15.99"}
     };
    }
}
