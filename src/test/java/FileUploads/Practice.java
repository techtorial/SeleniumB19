package FileUploads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class Practice {

    @Test
    public void practice1(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile=driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("/Users/techtorial/Downloads/usa.png");
        WebElement uploadButton=driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.submit();
        WebElement header=driver.findElement(By.tagName("h3"));
        String actualHeader= BrowserUtils.getText(header);
        String expectedHeader="File Uploaded!";
        Assert.assertEquals(actualHeader,expectedHeader);
    }

    @Test
    public void practice2() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/upload/");
        WebElement chooseFile=driver.findElement(By.cssSelector("#uploadfile_0"));
        chooseFile.sendKeys("/Users/techtorial/Downloads/usa.png");
        WebElement box=driver.findElement(By.cssSelector("#terms"));
        box.click();
        WebElement submitButton=driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submitButton.click();
        Thread.sleep(1000);
        WebElement message=driver.findElement(By.tagName("h3"));
        String actualMessage=BrowserUtils.getText(message);
        String expectedMessage="1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualMessage,expectedMessage);
    }









}
