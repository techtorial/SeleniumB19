package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsPractice {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> allLinks=driver.findElements(By.xpath("//li//a"));
        int counter=0;
        for(WebElement link:allLinks){
            System.out.println(link.getText().trim());
            System.out.println(link.getAttribute("href"));
            counter++;
            link.sendKeys(Keys.ARROW_DOWN);//how you arrow down the page
            Thread.sleep(500);
        }
        System.out.println(counter);
        System.out.println(allLinks.size());
        int counter2=0;
        for(WebElement link:allLinks){
            if(link.getText().length()>=12){
                System.out.println(link.getText().trim());
                counter2++;
            }
        }
        System.out.println(counter2);
    }
}
