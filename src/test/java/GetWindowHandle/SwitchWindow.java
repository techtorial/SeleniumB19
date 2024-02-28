package GetWindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {

    @Test
    public void switchWindow(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHere=driver.findElement(By.linkText("Click Here"));
        clickHere.click();//h3
        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        String mainPageID=driver.getWindowHandle();
        System.out.println(mainPageID);
        Set<String> allpages=driver.getWindowHandles();//2
        System.out.println(allpages);

        for(String id:allpages){
            if(!id.equals(mainPageID)){
                driver.switchTo().window(id);
            }
        }
        header=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
    }

    @Test
    public void switchWindowPractice() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement button2=driver.findElement(By.cssSelector("#newTabBtn"));
        Thread.sleep(3000);
        BrowserUtils.scrollIntoView(driver,button2);
        button2.click();
        String mainPageId=driver.getWindowHandle();//mainPageId
        Set<String> allPagesID=driver.getWindowHandles();//allPagesID

        for(String id:allPagesID){
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
            }
        }
        WebElement header=driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="AlertsDemo";
        Assert.assertEquals(actualHeader,expectedHeader);
//
        /*
    1-Navigate to the website
    2-Click Button2 if it throws exception then scroll to the button
    3-Validate the header "AlertsDemo"
    4-Click the first click me button
       */
    }












}
