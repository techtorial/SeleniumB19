package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsPractice {

    public static void main(String[] args) throws InterruptedException {
        //Setup your automation
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/form");
        WebElement firstName=driver.findElement(By.cssSelector("#first-name"));
        firstName.sendKeys("Ahmet");
        WebElement education=driver.findElement(By.id("radio-button-2"));
        education.click();
        WebElement date=driver.findElement(By.cssSelector("#datepicker"));
        date.sendKeys("08/13/2024");
        WebElement submitButton=driver.findElement(By.linkText("Submit"));
        submitButton.click();
        Thread.sleep(2000);
        WebElement message=driver.findElement(By.cssSelector(".alert"));
        String actualMessage=message.getText().trim();
        String expectedMessage="The form was successfully submitted!";
        System.out.println(actualMessage.equals(expectedMessage) ? "Passed":"Failed");
    }
}
