package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeDriverMethods {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());
        driver.navigate().to("https://www.wikipedia.org/");
        System.out.println(driver.getCurrentUrl());
        driver.get("https://www.pinterest.com/");
        System.out.println(driver.getTitle());
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        System.out.println(driver.getTitle());//youtube
        driver.navigate().forward();//wikipedia
        System.out.println(driver.getCurrentUrl());
        driver.navigate().refresh();
        driver.quit();
    }
}
