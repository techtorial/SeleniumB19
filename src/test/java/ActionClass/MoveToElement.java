package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MoveToElement {

    @Test
    public void moveToElement() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/hovers");
        List<WebElement> allNames=driver.findElements(By.xpath("//h5"));
        List<WebElement> allImages=driver.findElements(By.xpath("//img[@alt='User Avatar']"));
        List<String> expectedNames= Arrays.asList("name: user1","name: user2","name: user3");
        Actions actions=new Actions(driver);
        for(int i=0;i<allNames.size();i++){
            Thread.sleep(2000);
            actions.moveToElement(allImages.get(i)).perform();
            Assert.assertEquals(BrowserUtils.getText(allNames.get(i)),expectedNames.get(i));
            System.out.println(BrowserUtils.getText(allNames.get(i)));
        }
    }

    @Test
    public void practice() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");
        WebElement acceptCookies=driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        acceptCookies.click();
        Actions actions=new Actions(driver);
        actions.scrollByAmount(400,400).perform();
        List<WebElement> allImages=driver.findElements(By.xpath("//div[@class='product k-listview-item']//img"));
        List<WebElement> allNames=driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement> allPrices=driver.findElements(By.xpath("//div[@class='product-description']//p"));
        Map<String,String> allProduct=new LinkedHashMap<>();//insertion order
        for(int i=0;i<allNames.size();i++){
            actions.moveToElement(allImages.get(i)).perform();//hover over image
            Thread.sleep(200);
            allProduct.put(BrowserUtils.getText(allNames.get(i)),BrowserUtils.getText(allPrices.get(i)));
        }
        System.out.println(allProduct);
        /*
        1-Navigate to the website
        2-Accept Cookies if it pop ups.(Be careful about timing)
        3-Use actions.scrollByAmount(400,400) or any number to make sure the items look good on your screen if it necessary
        4-Get the all images location as a list
        5-Get the all Names location as a list
        6-Get the all Price location as a list
        7-Inside of regular loop Use actions move to element and put in the map (Key will be name , Value will be Price)
        8-Outside of loop, print out Map
        9-Proud of Yourself
         */
    }
}
