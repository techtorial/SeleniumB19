package SeleniumIntro;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class SeleniumDriverMethods {
    //driver.get()
    //driver.getTitle()
    //driver.getCurrentUrl()
    //driver.close()
    //driver.manage.window.maximize()
    //driver.navigate.to()-->also navigates to website
    //driver.navigate.refresh()
    //driver.navigate.forward()
    //driver.navigate.back()
    //driver.getPageSource()-->html structure on the console
    //driver.quit()

    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
//        WebDriver driver1=new ChromeDriver();//polymorphism
        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());
        Thread.sleep(1000);
        driver.navigate().back();//google
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(1000);
        driver.navigate().forward();//facebook
        System.out.println(driver.getTitle());
        Thread.sleep(1000);
        driver.navigate().refresh();
        System.out.println(driver.getPageSource());
        driver.quit();

    }
}
