package GetWindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
}
