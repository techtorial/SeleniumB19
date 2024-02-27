package JavaScriptExecutorClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class JavaScriptPractice {

    @Test
    public void practiceClickMethod() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");
        WebElement yesRadioButton = driver.findElement(By.xpath("//input[@id='yesRadio']"));
//        yesRadioButton.click();
//        Actions actions=new Actions(driver);
//        actions.click(yesRadioButton).perform();
        BrowserUtils.clickJS(driver, yesRadioButton);
        WebElement message = driver.findElement(By.cssSelector(".mt-3"));
        System.out.println(BrowserUtils.getText(message));
    }

    @Test
    public void allJSPractice() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        WebElement corporateTraining = driver.findElement(By.xpath("//div[contains(text(),'Corporate Training')]"));
        BrowserUtils.scrollIntoView(driver, corporateTraining);
        String actualText = BrowserUtils.getText(corporateTraining);
        String expectedText = "Corporate Training";
        Assert.assertEquals(actualText, expectedText);
        WebElement applyNowButton = driver.findElement(By.xpath("//span[.='Apply Now']"));
        BrowserUtils.clickJS(driver, applyNowButton);
        String actualTitle = BrowserUtils.getTitleJS(driver);
        String expectedTitle = "Apply Now";
        Assert.assertEquals(actualTitle, expectedTitle);
        List<WebElement> actualInformation=driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> expectedInformation= Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");

        for(int i=0;i<actualInformation.size();i++){
            Assert.assertEquals(BrowserUtils.getText(actualInformation.get(i)),expectedInformation.get(i));
        }

        /*
        1-Scroll All the way down to the Corporate Training and validate the name
        2-Scroll All the way up to Apply Now button at the corner and click with JS
        3-Validate title with JS
        4-Validate the information at the middle (info@techtorialacademy.com,+ 1 (224) 570 91 91,Chicago & Houston) (Arrays.asList logic)
        5-Close
         */
    }


}
