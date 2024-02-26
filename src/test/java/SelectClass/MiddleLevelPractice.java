package SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class MiddleLevelPractice {

    @Test
    public void validateOrderFlyTicketFunctionality() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWayButton=driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();
        WebElement passenger=driver.findElement(By.xpath("//select[@name='passCount']"));
//        Select passengerBox=new Select(passenger);
//        passengerBox.selectByValue("4");
        BrowserUtils.selectBy(passenger,"4","value");
        Thread.sleep(1000);
        WebElement fromPort=driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select fromPortBox=new Select(fromPort);
        String actualDefault=fromPortBox.getFirstSelectedOption().getText().trim();
        String expectedDefault="Acapulco";
        Assert.assertEquals(actualDefault,expectedDefault);
        Thread.sleep(1000);
        fromPortBox.selectByVisibleText("Paris");
        Thread.sleep(1000);
        WebElement fromMonth=driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select fromMonthBox=new Select(fromMonth);
        fromMonthBox.selectByValue("8");
        WebElement fromDay=driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select fromDayBox=new Select(fromDay);
        fromDayBox.selectByIndex(14);
        WebElement toPort=driver.findElement(By.xpath("//select[@name='toPort']"));
//        Select toPortBox=new Select(toPort);
//        toPortBox.selectByVisibleText("San Francisco");
        BrowserUtils.selectBy(toPort,"San Francisco","text");
        Thread.sleep(1000);
        WebElement toMonth=driver.findElement(By.xpath("//select[@name='toMonth']"));
//        Select toMonthBox=new Select(toMonth);
//        toMonthBox.selectByValue("12");
        BrowserUtils.selectBy(toMonth,"12","value");
        Thread.sleep(1000);
        WebElement toDay=driver.findElement(By.xpath("//select[@name='toDay']"));
//        Select toDayBox=new Select(toDay);
//        toDayBox.selectByIndex(14);
        BrowserUtils.selectBy(toDay,"14","index");
        WebElement serviceClass=driver.findElement(By.xpath("//input[@value='First']"));
        serviceClass.click();
        WebElement airline=driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlineBox=new Select(airline);
        List<WebElement> allAirlines=airlineBox.getOptions();
        List<String> expectedAirlines= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");

        for(int i=0;i<allAirlines.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allAirlines.get(i)),expectedAirlines.get(i).trim());
        }
        WebElement continueButton=driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();
        WebElement header=driver.findElement(By.xpath("//font[@size='4']"));
        String actualHeader= BrowserUtils.getText(header);   //header.getText().trim();
        String expectedHeader="After flight finder - No Seats Available";
        Assert.assertEquals(actualHeader,expectedHeader);
//allAirlines.get(i).getText().trim()
        //BrowserUtils.getText(allAirlines.get(i))
        /*
1-Navigate to the website (https://demo.guru99.com/test/newtours/reservation.php)
2-Select one way trip button
3-Choose 4 passangers
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message from header which should be "After flight finder - No Seats Available" (you can use font_size=4)

 NOTE:Your test should fail
 NOTE2:You can use any select method value,visibleText
 */

    }
}
