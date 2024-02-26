package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GetAttribute {

    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement makeAppointmentButton=driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAppointmentButton.click();
        WebElement usernameDemo=driver.findElement(By.xpath("//input[@value='John Doe']"));
        System.out.println(usernameDemo.getText().trim());
        System.out.println(usernameDemo.getAttribute("value"));//John Doe
        System.out.println(usernameDemo.getAttribute("placeholder"));//Username
    }
}
