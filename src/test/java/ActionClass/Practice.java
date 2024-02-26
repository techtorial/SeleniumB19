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

public class Practice {

    @Test
    public void practiceDragAndDrop(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        WebElement dragMeBox=driver.findElement(By.cssSelector("#draggable"));
        WebElement dropBox=driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String beforeActualText= BrowserUtils.getText(dropBox);
        String beforeExpectedText="Drop here";
        Assert.assertEquals(beforeActualText,beforeExpectedText);
        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragMeBox,dropBox).perform();
        String afterActualText=BrowserUtils.getText(dropBox);
        String afterExpectedText="Dropped!";
        Assert.assertEquals(afterActualText,afterExpectedText);
        String actualColor=dropBox.getCssValue("background-color");
        String expectedColor="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);
        /*
        1-navigate to the website
        2-Validate the box text is "Drop here"
        3-Drag and Drop the "Drag me" Box
        4-Validate the text changed to "Dropped!"
        5-Color changed to navy blue.
         */
    }

    @Test
    public void practiceClickAndHold(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        WebElement acceptButton=driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        Actions actions=new Actions(driver);
        actions.click(acceptButton).perform();
        WebElement acceptableButton=driver.findElement(By.cssSelector("#acceptable"));
        WebElement notAcceptableButton=driver.findElement(By.cssSelector("#notAcceptable"));
        WebElement dropBox=driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String beforeActualText=BrowserUtils.getText(dropBox);
        String beforeExpectedText="Drop here";
        Assert.assertEquals(beforeActualText,beforeExpectedText);
        actions.clickAndHold(notAcceptableButton).moveToElement(dropBox).release().perform();
        String afterActualText=BrowserUtils.getText(dropBox);
        String afterExpectedText="Drop here";
        Assert.assertEquals(afterActualText,afterExpectedText);
        actions.clickAndHold(acceptableButton).moveToElement(dropBox).release().perform();
        String afterActualTextAcceptable=BrowserUtils.getText(dropBox);
        String afterExpectedTextAcceptable="Dropped!";
        Assert.assertEquals(afterActualTextAcceptable,afterExpectedTextAcceptable);
        /*
        1-Navigate to the website
        2-Validate the text is Box text is "Drop here"
        3-Click and Hold Not acceptable box and release into Box
        4-Validate the box text is still "Drop here"
        5-Click and Hold Acceptable box and release into Box
        6-Validate box text is "Dropped!"

         */
    }













}
