package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LocatorsIntro {
    //LOCATOR:Is a way to locate(find) the element and manipulate on it.
    public static void main(String[] args) {
        //LOCATOR: ID Attribute
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/techtorial/Downloads/Techtorialhtml.html");
        WebElement header=driver.findElement(By.id("techtorial1"));
        String actualHeader=header.getText();//system
        String expectedHeader="Techtorial Academy";//story
        System.out.println(actualHeader.equals(expectedHeader) ? "Header Passed":"Header Failed");
        WebElement paragraph=driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());
        String actualData=paragraph.getText();
        String expectedWord="Please fill";
        System.out.println(actualData.contains(expectedWord)? "Paragraph PASSED":"Paragraph Failed");
        //LOCATOR: NAME Attribute
        WebElement firstName=driver.findElement(By.name("firstName"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.name("lastName"));
        lastName.sendKeys("Baldir");
        WebElement phone=driver.findElement(By.name("phone"));
        phone.sendKeys("13123123123");
        WebElement email=driver.findElement(By.id("userName"));
        email.sendKeys("ahmet@gmail.com");
        WebElement address=driver.findElement(By.name("address1"));
        address.sendKeys("asdasdas avenue");
        WebElement city=driver.findElement(By.name("city"));
        city.sendKeys("Des Plaines");
        WebElement state=driver.findElement(By.name("state"));
        state.sendKeys("IL");
        WebElement postCode=driver.findElement(By.name("postalCode"));
        postCode.sendKeys("54354");
        //LOCATOR:CLASS ATTRIBUTE
        WebElement tool=driver.findElement(By.className("group_checkbox"));
        System.out.println(tool);
        String actualText=tool.getText().trim();
        String expectedText="All Tools";
        System.out.println(actualText.equals(expectedText) ? "Text matches":"Text fails");
        WebElement javaBox=driver.findElement(By.id("cond1"));
//        System.out.println(javaBox.isSelected());
        Assert.assertFalse(javaBox.isSelected());
        if(javaBox.isDisplayed()&&!javaBox.isSelected()&&javaBox.isEnabled()){
            javaBox.click();
//            System.out.println(javaBox.isSelected()? "Selected Java" : "Not-Selected Java");
            Assert.assertTrue(javaBox.isSelected());
        }
        WebElement seleniumBox=driver.findElement(By.id("cond2"));
        if(seleniumBox.isDisplayed()&&!seleniumBox.isSelected()&&seleniumBox.isEnabled()){
            seleniumBox.click();
            System.out.println(seleniumBox.isSelected() ? "Selenium Selected" : "Selenium Not Selected");
        }else{
            System.out.println(seleniumBox.isSelected() ? "Selenium Selected" : "Selenium Not Selected");
        }
        driver.quit();
    }
}
