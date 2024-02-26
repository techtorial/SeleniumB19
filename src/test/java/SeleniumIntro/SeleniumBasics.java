package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {

    public static void main(String[] args) {
        //Create the WebDriver Object
        WebDriver driver=new ChromeDriver();//It is a way to make a connection
        //between local(computer) with Website(communication)
        driver.get("https://www.facebook.com/");//how you go to website
        String actualTitle=driver.getTitle();
        String expectedTitle="Facebook - log in or sign up";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title is Passed");
        }else{
            System.out.println("Title is Failed");
        }
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.facebook.com/";
        System.out.println(actualUrl.equals(expectedUrl) ? "URL PASSED":"URL FAILED");

        driver.close();
    }
}
