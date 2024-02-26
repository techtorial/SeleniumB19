package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/techtorial/Downloads/Techtorialhtml.html");
        //LOCATOR:TAG NAME
        WebElement javaVersion=driver.findElement(By.tagName("u"));
        System.out.println(javaVersion.getText());

        //LOCATOR:LINKTEXT
        WebElement javaButton=driver.findElement(By.linkText("Java"));
        javaButton.click();

        WebElement javaHeader=driver.findElement(By.tagName("h1"));
        System.out.println(javaHeader.getText().trim());

        driver.navigate().back();//home page
        WebElement seleniumButton=driver.findElement(By.linkText("Selenium"));
        seleniumButton.click();//Selenium Page
        WebElement seleniumHeader=driver.findElement(By.tagName("h1"));
        System.out.println(seleniumHeader.getText().trim());

        //LOCATOR:PartialLinkText

        driver.navigate().back();//main page
///       javaButton=driver.findElement(By.linkText("Java"));
//        driver.navigate().refresh();
//        javaButton.click();

        WebElement restApiButton=driver.findElement(By.partialLinkText("Api"));
        restApiButton.click();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        //LOCATOR: CSS
        WebElement mainHeader=driver.findElement(By.cssSelector("#techtorial1"));//id
        System.out.println(mainHeader.getText());
        WebElement box=driver.findElement(By.cssSelector(".group_checkbox"));//class
        System.out.println(box.getText().trim());

        driver.quit();
    }

}
