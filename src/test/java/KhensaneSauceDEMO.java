import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;

public class KhensaneSauceDEMO {
    WebDriver driver;


    @Test
    public void  loginWithValidDetails() throws InterruptedException {
        driver=new ChromeDriver();

        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[contains(@id,'login-button')]")).click();
        String productTExt=driver.findElement(By.xpath("//div[@class='product_label'][contains(.,'Products')]")).getText();

        Assert.assertEquals(productTExt,"Products");
        driver.findElement(By.xpath("(//button[@class='btn_primary btn_inventory'][contains(.,'ADD TO CART')])[1]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='btn_primary btn_inventory'][contains(.,'ADD TO CART')])[2]"))).click();
        WebElement removeButton = driver.findElement(By.xpath("(//button[contains(@class,'btn_secondary')][contains(.,'REMOVE')])[1]"));
        Assert.assertTrue(removeButton.isDisplayed(), "Remove button is not displayed after adding item to cart.");
        WebElement svgElement = driver.findElement(By.xpath("//svg[contains(@aria-hidden,'true')]"));
        svgElement.click();
        Thread.sleep(3000);








    }

    @AfterTest
    public void closeBroswer(){

        driver.quit();

    }

}
