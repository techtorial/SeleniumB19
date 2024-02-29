package Iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class NestedFrame {

    @Test
    public void nestedFrame(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top").switchTo().frame("frame-left");//top frame
//        driver.switchTo().frame("frame-left");//left frame
        WebElement leftText=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println(BrowserUtils.getText(leftText));
        driver.switchTo().parentFrame();// previous frame(html) --> TOP FRAME
        driver.switchTo().frame("frame-middle");
        WebElement middleText=driver.findElement(By.cssSelector("#content"));
        System.out.println(BrowserUtils.getText(middleText));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement rightText=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowserUtils.getText(rightText));
//        driver.switchTo().parentFrame();//Top Frame
////        driver.switchTo().parentFrame();//main HTML
        driver.switchTo().defaultContent();//it will directly go to the main html no matter what
        driver.switchTo().frame(1);//Bottom
        WebElement bottomText=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(bottomText));
    }
}
