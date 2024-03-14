package WaitTimes;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitlyWait {

    /*
    It is a way to handle wait issues.
    We implement under DriverHelper once we create our driver
     */
    @Test
    public void implicitlyWait(){
        ChromeDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}
