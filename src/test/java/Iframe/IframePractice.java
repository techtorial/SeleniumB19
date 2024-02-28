package Iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class IframePractice {

    @Test
    public void frame(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        driver.switchTo().frame("mce_0_ifr");
        WebElement box=driver.findElement(By.cssSelector("#tinymce"));
        box.clear();
        box.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        WebElement elementalSelenium=driver.findElement(By.linkText("Elemental Selenium"));
        elementalSelenium.click();
    }
}
