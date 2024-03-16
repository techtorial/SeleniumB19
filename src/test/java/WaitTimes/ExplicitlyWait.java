package WaitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class ExplicitlyWait {

    /*
    1-It is a way to handle wait time issue in Selenium
    2-We need to create an object
    3-We need to provide conditions
     */

    @Test
    public void explicitlyWait() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement button=driver.findElement(By.xpath("//button"));
        button.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement message=driver.findElement(By.xpath("//div[@id='finish']//h4"));
         message=wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertEquals(BrowserUtils.getText(message),"Hello World!");
    }

    @Test
    public void practice(){

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        WebElement button=driver.findElement(By.xpath("//button"));
        button.click();
//        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement message=driver.findElement(By.xpath("//h4[.='Hello World!']"));
//        message=wait.until(ExpectedConditions.visibilityOf(message));
        BrowserUtils.explicitlyWait(driver,message,"visibility");
        System.out.println(message);
        Assert.assertEquals(BrowserUtils.getText(message),"Hello World!");
    }

    @Test
    public void fluentWait(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement button=driver.findElement(By.xpath("//button[.='Remove']"));
        button.click();
        Wait<WebDriver> fluentWait=new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(5))
                .withMessage("Text is not on the page")
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);
        WebElement message=fluentWait.until(mydriver->driver.findElement(By.cssSelector("#message")));
        System.out.println(BrowserUtils.getText(message));
    }



}
