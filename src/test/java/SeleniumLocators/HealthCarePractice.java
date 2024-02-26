package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class HealthCarePractice {

    /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or .equals XPATH METHOD
10-Validate the header is "Appointment Confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.
     */
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement makeAppointmentButton=driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAppointmentButton.click();
        WebElement demoUsername=driver.findElement(By.xpath("//input[@aria-describedby='demo_username_label']"));
        WebElement demoPassword=driver.findElement(By.xpath("//input[@aria-describedby='demo_password_label']"));
        WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys(demoUsername.getAttribute("value"));
        WebElement password=driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys(demoPassword.getAttribute("value"));
        WebElement loginButton=driver.findElement(By.xpath("//button"));
        loginButton.click();
        WebElement facility=driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");
        WebElement readmission=driver.findElement(By.xpath("//input[@name='hospital_readmission']"));
        Assert.assertFalse(readmission.isSelected());
        Assert.assertTrue(readmission.isDisplayed());
        Assert.assertTrue(readmission.isEnabled());
        if(readmission.isDisplayed() && readmission.isEnabled() && !readmission.isSelected()){
            readmission.click();
        }
//        System.out.println(readmission.isSelected() ? "Box Selected" : "Box Not Selected");
       Assert.assertTrue(readmission.isSelected());
        WebElement medicaid=driver.findElement(By.xpath("//input[@value='Medicaid']"));
        medicaid.click();
        WebElement visitDate=driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        visitDate.sendKeys("21/02/2024");
        WebElement comment=driver.findElement(By.xpath("//textarea"));
        comment.sendKeys("I love Selenium");
        WebElement bookAppointment=driver.findElement(By.xpath("//button[@type='submit']"));
        bookAppointment.click();
        WebElement confirmationHeader=driver.findElement(By.xpath("//h2[contains(text(),'Appointment')]"));
        String actualHeader=confirmationHeader.getText().trim();
        String expectedHeader="Appointment Confirmation";
        System.out.println(actualHeader.equals(expectedHeader) ? "Header Passed" : "Header Failed");
        WebElement facilityValidation=driver.findElement(By.xpath("//p[.='Hongkong CURA Healthcare Center']"));
        System.out.println(facilityValidation.getText().trim());
        WebElement homepageButton=driver.findElement(By.xpath("//a[.='Go to Homepage']"));
        homepageButton.click();
        System.out.println(driver.getCurrentUrl());








    }
}