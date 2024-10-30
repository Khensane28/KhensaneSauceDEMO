package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(.,'Products')]")
    WebElement product_xpath;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyProductTitleIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(product_xpath));

        // The below does axactly the same thing, you need to use one
        product_xpath.isDisplayed();

        String productTExt = product_xpath.getText();
        Assert.assertEquals(productTExt, "Products");
    }


}
