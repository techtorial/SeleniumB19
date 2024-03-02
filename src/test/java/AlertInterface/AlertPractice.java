package AlertInterface;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertPractice {

    @Test
    public void practice(){
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");
        WebElement alert=driver.findElement(By.cssSelector("#alertBox"));
        alert.click();
        Alert alert1=driver.switchTo().alert();
        String actualText=alert1.getText();
        String expectedText="I am an alert box!";
        Assert.assertEquals(actualText,expectedText);
        alert1.accept();
        WebElement message=driver.findElement(By.cssSelector("#output"));
        String actualMessage= BrowserUtils.getText(message);
        String expectedMessage="You selected alert popup";
        Assert.assertEquals(actualMessage,expectedMessage);
        WebElement confirm=driver.findElement(By.cssSelector("#confirmBox"));
        confirm.click();
        alert1.dismiss();
        message=driver.findElement(By.cssSelector("#output"));
        String actualMessageConfirm= BrowserUtils.getText(message);
        String expectedMessageConfirm="You pressed Cancel in confirmation popup";
        Assert.assertEquals(actualMessageConfirm,expectedMessageConfirm);
        WebElement prompt=driver.findElement(By.cssSelector("#promptBox"));
        prompt.click();
        alert1.sendKeys("Ahmet");
        alert1.accept();
        message=driver.findElement(By.cssSelector("#output"));
        String actualMessagePrompt= BrowserUtils.getText(message);
        String expectedMessagePrompt="You entered text Ahmet in prompt popup";
        Assert.assertEquals(actualMessagePrompt,expectedMessagePrompt);
    }
}
