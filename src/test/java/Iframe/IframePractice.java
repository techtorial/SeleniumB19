package Iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class IframePractice {

    @Test
    public void frame() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        driver.switchTo().frame("mce_0_ifr"); //html2
        WebElement box = driver.findElement(By.cssSelector("#tinymce"));
        box.clear();
        box.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();//html
        WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        elementalSelenium.click();
    }

    @Test
    public void practiceFrame() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://skpatro.github.io/demo/iframes");
        WebElement pavilionButton = driver.findElement(By.linkText("Pavilion"));
        pavilionButton.click();
        BrowserUtils.switchWindow(driver, "qavalidation");
        WebElement selenium = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(selenium).perform();
        WebElement seleniumPhyton = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Python']"));
        seleniumPhyton.click();
        List<WebElement> allLinks = driver.findElements(By.xpath("//p//a"));

        for (WebElement link : allLinks) {
            System.out.println(BrowserUtils.getText(link));
        }
        Assert.assertEquals(allLinks.size(), 22);

        BrowserUtils.switchWindow(driver, "iframes");
        driver.switchTo().frame("Framename1");
        WebElement category1 = driver.findElement(By.linkText("Category1"));
        category1.click();
        BrowserUtils.switchWindow(driver, "SeleniumTesting Archives");
        WebElement header = driver.findElement(By.tagName("h1"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "Category Archives: SeleniumTesting";
        Assert.assertEquals(actualHeader, expectedHeader);

        List<WebElement> allTexts = driver.findElements(By.xpath("//h3"));
        for (WebElement text : allTexts) {
            System.out.println(BrowserUtils.getText(text));
        }
        Assert.assertEquals(allTexts.size(), 9);

        BrowserUtils.switchWindow(driver, "iframes");

        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@id='Frame1']"));
        driver.switchTo().frame(iframe1);
        WebElement text = driver.findElement(By.cssSelector("#frametext"));
        System.out.println(BrowserUtils.getText(text));
        driver.switchTo().parentFrame();//html
        driver.switchTo().frame("Frame2");//frame2
        WebElement category3 = driver.findElement(By.linkText("Category3"));
        category3.click();
        BrowserUtils.switchWindow(driver, "SoftwareTesting Archives");
        header = driver.findElement(By.tagName("h1"));
        System.out.println(BrowserUtils.getText(header));
        driver.quit();


        /*
          TASK 1:
        1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
        2-Click Pavilion
        3-Hover Over Selenium then click Selenium-Phyton
        4-Print out all the links(only links) and validate size is 22

        TASK2:
        1-Click the category 1 button
        2-Validate the header is "Category Archives: SeleniumTesting"
        3-Print out the top of the each box(text) and validate size is 9 I showed you during manual steps

       TASK3:
        1-Go to the iframe tab
        2-print out "I am inside Frame"
        3-Click category 3
        4-print out the header "Category Archives: SoftwareTesting"
         */
    }


}
