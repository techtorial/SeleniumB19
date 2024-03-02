package SoftAssertClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

import java.time.Duration;

public class SoftAssertLogic {

    public int getSum(int number1,int number2){
        return number1+number2;
    }

    @Test
    public void hardAssert(){
        Assert.assertEquals(getSum(1,3),4);
        System.out.println("test1");
        Assert.assertEquals(getSum(3,8),10);
        System.out.println("test2");
        Assert.assertEquals(getSum(7,0),7);
        System.out.println("test3");
    }

    @Test
    public void softAssert(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(getSum(1,3),4);
        System.out.println("test1");
        softAssert.assertEquals(getSum(3,8),10);
        System.out.println("test2");
        softAssert.assertEquals(getSum(7,0),7);
        System.out.println("test3");
        softAssert.assertAll();
    }

    @Test
    public void practiceSoftAssert(){
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
        String beforeActualText= BrowserUtils.getText(dropBox);
        String beforeExpectedText="Drop heres";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(beforeActualText,beforeExpectedText);
        actions.clickAndHold(notAcceptableButton).moveToElement(dropBox).release().perform();
        String afterActualText=BrowserUtils.getText(dropBox);
        String afterExpectedText="Drop here";
        Assert.assertEquals(afterActualText,afterExpectedText);
        actions.clickAndHold(acceptableButton).moveToElement(dropBox).release().perform();
        String afterActualTextAcceptable=BrowserUtils.getText(dropBox);
        String afterExpectedTextAcceptable="Dropped!";
        Assert.assertEquals(afterActualTextAcceptable,afterExpectedTextAcceptable);
        softAssert.assertAll();
    }

}
