package AlertInterface;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class HtmlPractice {

    @Test
    public void practice() throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://sweetalert.js.org/");
        WebElement jsPreview=driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        jsPreview.click();
        Alert alert=driver.switchTo().alert();
        String actualText=alert.getText();
        String expectedText="Oops, something went wrong!";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
        WebElement sweetAlert=driver.findElement(By.xpath("//h5[contains(text(),'SweetAlert')]//..//button"));
        sweetAlert.click();
        Thread.sleep(2000);
        WebElement text=driver.findElement(By.xpath("//div[contains(text(),'Something')]"));
        Assert.assertTrue(BrowserUtils.getText(text).contains("Something went wrong!"));
        WebElement okButton=driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();

    }
}
