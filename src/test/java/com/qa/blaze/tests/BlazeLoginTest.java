package com.qa.blaze.tests;

import com.qa.blaze.pages.BlazeLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class BlazeLoginTest extends BlazeTestBase{

//    @Test
//    public void validateSignUpAndLoginFunctionality() throws InterruptedException {
//        BlazeLoginPage blazeLoginPage=new BlazeLoginPage(driver);
//        blazeLoginPage.signUpFunctionality(driver,
//                ConfigReader.readProperty("blazeusername"),
//                ConfigReader.readProperty("blazepassword"),
//                "Sign up successful.");
//        blazeLoginPage.loginFunctionality(ConfigReader.readProperty("blazeusername"),
//                ConfigReader.readProperty("blazepassword"));
//    }
    @Parameters("message")
    @Test
    public void validateSignUpAndLoginFunctionalityParameters(String message) throws InterruptedException {
        BlazeLoginPage blazeLoginPage=new BlazeLoginPage(driver);
        blazeLoginPage.signUpFunctionality(driver,
                ConfigReader.readProperty("blazeusername"),
                ConfigReader.readProperty("blazepassword"), message);
        blazeLoginPage.loginFunctionality(ConfigReader.readProperty("blazeusername"),
                ConfigReader.readProperty("blazepassword"));
    }
}
