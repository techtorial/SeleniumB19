package GetWindowHandle;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class MultipleWindows {


    @Test
    public void multipleWindows() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/about')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        Set<String> allPagesId=driver.getWindowHandles(); //4 ids

        for(String id:allPagesId){
            driver.switchTo().window(id);
            if(driver.getTitle().equals("About")){
                break;
            }
        }
        System.out.println(driver.getTitle());
        Thread.sleep(2000);

        for(String id:allPagesId){
            driver.switchTo().window(id);
            if(driver.getTitle().equals("Contact us")){
                break;
            }
        }
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        for(String id:allPagesId){
            driver.switchTo().window(id);
            if(driver.getTitle().contains("Kickstart")){
                break;
            }
        }
        System.out.println(driver.getTitle());
    }

    @Test
    public void browserUtilsWindow() throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/about')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        BrowserUtils.switchWindow(driver,"About");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        BrowserUtils.switchWindow(driver,"Contact us");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        BrowserUtils.switchWindow(driver,"Kickstart");
        System.out.println(driver.getTitle());
    }

    @Test
    public void practiceAll(){

    }









}
