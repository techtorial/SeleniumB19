package AlertInterface;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertIntro {

    @Test
    public void AcceptAndGetTextMethod(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlert=driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        jsAlert.click();
        Alert alert=driver.switchTo().alert();
        String actualText= alert.getText().trim();
        String expectedText="I am a JS Alert";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
        WebElement message=driver.findElement(By.cssSelector("#result"));
        System.out.println(BrowserUtils.getText(message));
    }
    @Test
    public void Dismiss() throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirmButton=driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));
        jsConfirmButton.click();
        Thread.sleep(1000);
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
        WebElement result=driver.findElement(By.cssSelector("#result"));
        String actualResult=BrowserUtils.getText(result);
        String expectedResult="You clicked: Cancel";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void sendKeys(){
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement promptButton=driver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt')]"));
        promptButton.click();
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("I love Selenium");
        alert.accept();
        WebElement result=driver.findElement(By.cssSelector("#result"));
        String actualResult=BrowserUtils.getText(result);
        String expectedResult="You entered: I love Selenium";
        Assert.assertEquals(actualResult,expectedResult);



    }












}
