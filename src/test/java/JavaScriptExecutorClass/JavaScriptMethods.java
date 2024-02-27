package JavaScriptExecutorClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class JavaScriptMethods {

    /*
    NOTE:JavaScript is a programming Language
    NOTE:Javascript method should be your "LAST OPTION" if regular Selenium methods are not working
     */

    @Test
    public void getTitle(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        System.out.println(driver.getTitle());
//        JavascriptExecutor js= (JavascriptExecutor) driver;
//        System.out.println( js.executeScript("return document.title")+" for JS");
        System.out.println(BrowserUtils.getTitleJS(driver));
    }

    @Test
    public void clickJS(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        WebElement aboutUs=driver.findElement(By.xpath("//span[.='About Us']"));
        //1-First try WebElement.click() -->If no
        //2-Second try Actions.click() -->If no
        //3-Last try JavaScript.click()
//        JavascriptExecutor js= (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click()",aboutUs);
        BrowserUtils.clickJS(driver,aboutUs);
    }

    @Test
    public void scrollIntoView() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        WebElement copyRight=driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
//        JavascriptExecutor js= (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true)",copyRight);
        BrowserUtils.scrollIntoView(driver,copyRight);
        System.out.println(BrowserUtils.getText(copyRight));
        Thread.sleep(3000);
        WebElement launch=driver.findElement(By.xpath("//b[.='LAUNCH A NEW TECH CAREER']"));
//        js.executeScript("arguments[0].scrollIntoView(true)",launch);
        BrowserUtils.scrollIntoView(driver,launch);
        System.out.println(BrowserUtils.getText(launch));
        Thread.sleep(3000);
        WebElement middle=driver.findElement(By.xpath("//h2[contains(text(),'The best learning')]"));
//        js.executeScript("arguments[0].scrollIntoView(true)",middle);
        BrowserUtils.scrollIntoView(driver,middle);

    }














}
