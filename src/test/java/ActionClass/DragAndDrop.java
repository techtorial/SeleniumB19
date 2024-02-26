package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class DragAndDrop {

    @Test
    public void DragAndDropMethod() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement acceptCookies=driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        Actions actions=new Actions(driver);
        Thread.sleep(2000);
        actions.click(acceptCookies).perform();
        actions.scrollByAmount(300,300).perform();
        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement orangeBox=driver.findElement(By.xpath("//div[@class='test2']"));
        String beforeDragAndDropOrange= BrowserUtils.getText(orangeBox);
        String expectedBeforeOrange="... Or here.";
        Assert.assertEquals(beforeDragAndDropOrange,expectedBeforeOrange);
        String actualBackgroundColor=orangeBox.getCssValue("background-color");
        String expectedBackGroundColor="rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualBackgroundColor,expectedBackGroundColor);
        actions.dragAndDrop(draggable,orangeBox).perform();
        orangeBox=driver.findElement(By.xpath("//div[@class='test2']"));
        String afterDragAndDropOrange= BrowserUtils.getText(orangeBox);
        String expectedAfterOrange="You did great!";
        Assert.assertEquals(afterDragAndDropOrange,expectedAfterOrange);
    }

    @Test
    public void ClickAndHold() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement acceptCookies=driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        Actions actions=new Actions(driver);
        Thread.sleep(2000);
        actions.click(acceptCookies).perform();
        actions.scrollByAmount(300,300).perform();
        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement blueBox=driver.findElement(By.xpath("//div[@class='test1']"));
        String beforeActualBlueText=BrowserUtils.getText(blueBox);
        String beforeExpectedBlueText="Drag the small circle here ...";
        Assert.assertEquals(beforeActualBlueText,beforeExpectedBlueText);
        actions.clickAndHold(draggable).moveToElement(blueBox).release().perform();
        blueBox=driver.findElement(By.xpath("//div[@class='test1']"));
        String afterActualBlueText=BrowserUtils.getText(blueBox);
        String afterExpectedBlueText="You did great!";
        Assert.assertEquals(afterActualBlueText,afterExpectedBlueText);
        String actualColorBlueBox=blueBox.getCssValue("background-color");
        String expectedColorBlueBox="rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualColorBlueBox,expectedColorBlueBox);








    }
}
