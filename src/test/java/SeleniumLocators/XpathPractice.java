package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathPractice {

    /*
    1-Navigate to the http://tutorialsninja.com/demo/index.php?route=account/register
    2-Provide all the information
    3-Check the privacy box is displayed, not selected and enabled then click'
    4-Click Continue Button
    5-Validate the message "Your Account Has Been Created!"
    6-Click Continue Button
    7-Validate the current Url "https://tutorialsninja.com/demo/index.php?route=account/account"
    8-driver.quit()
    NOTE:Please use all XPATH Locator
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
        WebElement firstName=driver.findElement(By.xpath("//input[@id='input-firstName']"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Baldir");
        WebElement email=driver.findElement(By.xpath("//input[@placeholder='E-Mail']"));
        email.sendKeys("ahmet54654346@gmail.com");
        WebElement telephone=driver.findElement(By.xpath("//input[@type='tel']"));
        telephone.sendKeys("123123123");
        WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("Ahmet123");
        WebElement confirmPassword=driver.findElement(By.xpath("//input[@name='confirm']"));
        confirmPassword.sendKeys("Ahmet123");
        WebElement privacyBox=driver.findElement(By.xpath("//input[@type='checkbox']"));
        if(privacyBox.isEnabled()&&privacyBox.isDisplayed()&&!privacyBox.isSelected()){
            privacyBox.click();
        }
        WebElement continueButton=driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();
        Thread.sleep(3000);
        WebElement header=driver.findElement(By.xpath("//h1[contains(text(),'Created')]"));
        String actualHeader=header.getText().trim();
        String expectedHeader="Your Account Has Been Created!";
        System.out.println(actualHeader.equals(expectedHeader) ? "Register PASS":"Register Failed");
        WebElement continueButton2=driver.findElement(By.xpath("//a[.='Continue']"));
        continueButton2.click();
        String actualUrl=driver.getCurrentUrl().trim();
        String expectedUrl="https://tutorialsninja.com/demo/index.php?route=account/account";
        System.out.println(actualUrl.equals(expectedUrl) ?  "URL PASSED": "URL FAILED");
        Thread.sleep(5000);
        driver.quit();



    }











}
