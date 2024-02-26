package TestNGConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SauceLab {

    @Test
    public void validateHappyPathLoginFunctionality(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        WebElement username=driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys("standard_user");
        WebElement password=driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton=driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualUrl,expectedUrl);
        String actualTitle=driver.getTitle();
        String expectedTitle="Swag Labs";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void negativeLogin(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        WebElement username=driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys("standard_user");
        WebElement password=driver.findElement(By.cssSelector("#password"));
        password.sendKeys("randomndsafsdf");
        WebElement loginButton=driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();
        WebElement errorMessage=driver.findElement(By.xpath("//h3[@data-test='error']"));
        String actualMessage=errorMessage.getText().trim();
        String expectedMessage="Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void validateProductDescription(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        WebElement username=driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys("standard_user");
        WebElement password=driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton=driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();
        List<WebElement> allItems=driver.findElements(By.cssSelector(".inventory_item_name "));
        Assert.assertEquals(allItems.size(),6);
        for(WebElement item:allItems){
            if(item.getText().trim().equals("Sauce Labs Bolt T-Shirt")){
                item.click();
                break;
            }
        }
        WebElement header=driver.findElement(By.cssSelector(".inventory_details_name"));
        String actualHeader=header.getText().trim();
        String expectedHeader="Sauce Labs Bolt T-Shirt";
        Assert.assertEquals(actualHeader,expectedHeader);
        WebElement description=driver.findElement(By.cssSelector(".inventory_details_desc"));
        String actualDescription=description.getText().trim();
        String expectedDescription="Sauce Labs bolt T-shirt";
        Assert.assertTrue(actualDescription.contains(expectedDescription));
        WebElement price=driver.findElement(By.cssSelector(".inventory_details_price"));
        String actualPrice=price.getText().trim();
        String expectedPrice="$15.99";
        Assert.assertEquals(actualPrice,expectedPrice);
        WebElement addToCartButton=driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt"));
        Assert.assertTrue(addToCartButton.isDisplayed()&&addToCartButton.isEnabled());

        /*
Homework:
1-Navigate to website https://www.saucedemo.com/
2-Login Successfully with username and password
3-Store all the elements and validate there are 6 items on the website (list.size method might help)
4-Loop through all items and once this element name is "Sauce Labs Bolt T-Shirt" then click and break
5-Validate the header "Sauce Labs Bolt T-Shirt"
6-Validate the description contains(Sauce Labs bolt T-shirt)
7-Validate the price "$15.99"
8-Validate the Add to card is displayed on the page.
Let me know if you have any questions. We will do it on Saturday together. It is good to do it by yourself.
*/

    }
    @Test
    public void validateOrderFunctionality(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        WebElement username=driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys("standard_user");
        WebElement password=driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton=driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();
        List<WebElement> allItems=driver.findElements(By.cssSelector(".inventory_item_name "));
        for(WebElement item:allItems){
            if(item.getText().trim().equals("Sauce Labs Bolt T-Shirt")){
                item.click();
                break;
            }
        }
        WebElement addToCartButton=driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt"));
        addToCartButton.click();
        WebElement shoppingCartIcon=driver.findElement(By.cssSelector(".shopping_cart_link"));
        shoppingCartIcon.click();
        WebElement headerOfItem=driver.findElement(By.cssSelector(".inventory_item_name"));
        String actualHeader=headerOfItem.getText().trim();
        String expectedHeader="Sauce Labs Bolt T-Shirt";
        Assert.assertEquals(actualHeader,expectedHeader);
        WebElement checkOutButton=driver.findElement(By.cssSelector("#checkout"));
        checkOutButton.click();
        WebElement firstName=driver.findElement(By.cssSelector("#first-name"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.cssSelector("#last-name"));
        lastName.sendKeys("Baldir");
        WebElement zipCode=driver.findElement(By.cssSelector("#postal-code"));
        zipCode.sendKeys("42342");
        WebElement continueButton=driver.findElement(By.cssSelector("#continue"));
        continueButton.click();
        WebElement itemTotal=driver.findElement(By.cssSelector(".summary_subtotal_label"));
        System.out.println(itemTotal.getText().trim().substring(itemTotal.getText().length()-5));
        System.out.println(itemTotal.getText().trim().substring(itemTotal.getText().indexOf('$')+1));
        double actualItemTotal=Double.parseDouble(itemTotal.getText().trim().substring(itemTotal.getText().indexOf('$')+1));
        WebElement tax=driver.findElement(By.cssSelector(".summary_tax_label"));
        double actualTax=Double.parseDouble(tax.getText().trim().substring(tax.getText().indexOf('$')+1));
        WebElement totalPrice=driver.findElement(By.cssSelector(".summary_total_label"));
        double actualTotalPrice=Double.parseDouble(totalPrice.getText().trim().substring(totalPrice.getText().indexOf('$')+1));
        Assert.assertEquals(actualTotalPrice,(actualItemTotal+actualTax));
        WebElement finishButton=driver.findElement(By.cssSelector("#finish"));
        finishButton.click();
        WebElement message=driver.findElement(By.xpath("//div[@id='checkout_complete_container']//h2"));
        String actualMessage=message.getText().trim();
        String expectedMessage="Thank you for your order!";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
    /*
    1-Click Add to Card button
    2-Click the cart at the top right
    3-Validate the name of the item "Sauce Labs Bolt T-Shirt" header
    4-Click check out button
    5-Provide the information
    6-Add the item total(15.99) and tax(1.28) and validate this number with total(17.27)
    7-Click Finish Button
    8-Validate "Thank you for your order!"
    9-driver.quit()
     */

}
