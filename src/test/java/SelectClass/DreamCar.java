package SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {

    @Test
    public void searchFunctionality() throws InterruptedException {
        /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New & used" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption -->regular select
6-Choose the distance 40 miles
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header contains  "New and used Lexus RX 350 for sale"
11-Validate the all titles has Lexus RX 350
 */
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cars.com/shopping/");
        Thread.sleep(3000);
        WebElement xButton=driver.findElement(By.cssSelector(".banner-close-button"));
        xButton.click();
        WebElement newUsed=driver.findElement(By.cssSelector("#make-model-search-stocktype"));
        BrowserUtils.selectBy(newUsed,"New & used","text");
        WebElement make=driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(make,"lexus","value");
        WebElement models=driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(models,"lexus-rx_350","value");
        WebElement price=driver.findElement(By.cssSelector("#make-model-max-price"));
        Select priceBox=new Select(price);
        String actualPrice=BrowserUtils.getText(priceBox.getFirstSelectedOption());
        String expectedPrice="No max price";
        Assert.assertEquals(actualPrice,expectedPrice);
        WebElement distance=driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(distance,"40 miles","text");
        WebElement zipCode=driver.findElement(By.cssSelector("#make-model-zip"));
        zipCode.clear();
        zipCode.sendKeys("60056", Keys.ENTER);

    //    WebElement searchButton=driver.findElement(By.xpath("//button[@data-linkname='search-all-make']"));
//       Thread.sleep(3000);
//        searchButton.click();

        WebElement header=driver.findElement(By.tagName("h1"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="New and used Lexus RX 350 for sale";
        Assert.assertTrue(actualHeader.contains(expectedHeader));
        List<WebElement> allTitles=driver.findElements(By.xpath("//h2[@class='title']"));

        for(WebElement title:allTitles){
            Assert.assertTrue(BrowserUtils.getText(title).contains("Lexus RX 350"));
        }
    }
    @Test
    public void validateLowestToHighestFunctionality() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cars.com/shopping/");
        Thread.sleep(3000);
        WebElement xButton=driver.findElement(By.cssSelector(".banner-close-button"));
        xButton.click();
        WebElement newUsed=driver.findElement(By.cssSelector("#make-model-search-stocktype"));
        BrowserUtils.selectBy(newUsed,"New & used","text");
        WebElement make=driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(make,"lexus","value");
        WebElement models=driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(models,"lexus-rx_350","value");
        WebElement price=driver.findElement(By.cssSelector("#make-model-max-price"));
        Select priceBox=new Select(price);
        String actualPrice=BrowserUtils.getText(priceBox.getFirstSelectedOption());
        String expectedPrice="No max price";
        Assert.assertEquals(actualPrice,expectedPrice);
        WebElement distance=driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(distance,"40 miles","text");
        WebElement zipCode=driver.findElement(By.cssSelector("#make-model-zip"));
        zipCode.clear();
        zipCode.sendKeys("60056");
        WebElement searchButton=driver.findElement(By.xpath("//button[@data-linkname='search-all-make']"));
        Thread.sleep(3000);
        searchButton.click();
        WebElement sortBy=driver.findElement(By.cssSelector("#sort-dropdown"));
        BrowserUtils.selectBy(sortBy,"Lowest price","text");
        Thread.sleep(3000);
        List<WebElement> allPrices=driver.findElements(By.cssSelector(".primary-price"));//20

        List<Integer> actualOrder=new ArrayList<>();
        List<Integer> expectedOrder=new ArrayList<>();
//$7,950 -->"7950"
        Thread.sleep(3000);
        for(WebElement prices:allPrices){
            actualOrder.add(Integer.parseInt(BrowserUtils.getText(prices).replace("$","").replace(",","")));
            expectedOrder.add(Integer.parseInt(BrowserUtils.getText(prices).replace("$","").replace(",","")));
        }
        System.out.println(actualOrder);
        System.out.println(expectedOrder);
        Collections.sort(expectedOrder);
        Assert.assertEquals(actualOrder,expectedOrder);
    }

    @Test
    public void validateHighestToLowestFunctionality() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cars.com/shopping/");
        Thread.sleep(3000);
        WebElement xButton=driver.findElement(By.cssSelector(".banner-close-button"));
        xButton.click();
        WebElement newUsed=driver.findElement(By.cssSelector("#make-model-search-stocktype"));
        BrowserUtils.selectBy(newUsed,"New & used","text");
        WebElement make=driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(make,"lexus","value");
        WebElement models=driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(models,"lexus-rx_350","value");
        WebElement price=driver.findElement(By.cssSelector("#make-model-max-price"));
        Select priceBox=new Select(price);
        String actualPrice=BrowserUtils.getText(priceBox.getFirstSelectedOption());
        String expectedPrice="No max price";
        Assert.assertEquals(actualPrice,expectedPrice);
        WebElement distance=driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(distance,"40 miles","text");
        WebElement zipCode=driver.findElement(By.cssSelector("#make-model-zip"));
        zipCode.clear();
        zipCode.sendKeys("60056");
        WebElement searchButton=driver.findElement(By.xpath("//button[@data-linkname='search-all-make']"));
        Thread.sleep(3000);
        searchButton.click();
        WebElement sortBy=driver.findElement(By.cssSelector("#sort-dropdown"));
        BrowserUtils.selectBy(sortBy,"Highest price","text");
        Thread.sleep(3000);
        List<WebElement> allPrices=driver.findElements(By.cssSelector(".primary-price"));//20

        List<Integer> actualOrder=new ArrayList<>();
        List<Integer> expectedOrder=new ArrayList<>();
//$7,950 -->"7950"
        Thread.sleep(3000);
        for(WebElement prices:allPrices){
            actualOrder.add(Integer.parseInt(BrowserUtils.getText(prices).replace("$","").replace(",","")));
            expectedOrder.add(Integer.parseInt(BrowserUtils.getText(prices).replace("$","").replace(",","")));
        }
        Collections.sort(expectedOrder);
        Collections.reverse(expectedOrder);
        System.out.println(expectedOrder);
        System.out.println(actualOrder);
        Assert.assertEquals(actualOrder,expectedOrder);
    }
















}
