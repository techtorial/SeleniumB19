package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathLocator {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/");
        WebElement abTesting=driver.findElement(By.partialLinkText("Testing"));
        abTesting.click();
        WebElement header=driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"));
        System.out.println(header.getText().trim());
        WebElement paragraph=driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
        System.out.println(paragraph.getText().trim());
//        WebElement seleniumLink=driver.findElement(By.xpath("//a[contains(text(),'Elemental')]"));
        WebElement seleniumLink=driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
        seleniumLink.click();
    }
}
