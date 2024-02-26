package SeleniumIntro;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class PracticeGetAttributeAndLoops {

    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");
        Thread.sleep(2000);
       WebElement collapseButton= driver.findElement(By.xpath("//button"));
        collapseButton.click();
        List<WebElement> allBoxes=driver.findElements(By.xpath("//div[@role='checkbox']"));

        for(WebElement box: allBoxes){
            if(box.getAttribute("aria-checked").equals("false")){
                box.click();
            }
        }









    }
}
