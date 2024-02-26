package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsMethod {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/techtorial/Downloads/Techtorialhtml.html");
        List<WebElement> allBoxes=driver.findElements(By.xpath("//input[@type='checsdsdkbox']"));

        for(WebElement box: allBoxes){
            if(box.isDisplayed() && box.isEnabled() && !box.isSelected()){
                box.click();
                Thread.sleep(2000);
            }
            System.out.println(box.isSelected() ?  "PASSED" : "FAILED");
        }
    }
}
