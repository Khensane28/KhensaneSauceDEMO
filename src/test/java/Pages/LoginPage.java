package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@name='user-name']")
    WebElement username_xpath;

    @FindBy(id = "password")
    WebElement password_id;

    @FindBy(name = "login-button")
    WebElement loginButton_name;

    @FindBy(xpath = "//h3[contains(.,'Epic sadface: Username and password do not match any user in this service')]")
    WebElement loginError_xpath;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(username_xpath));
        username_xpath.clear();
        username_xpath.sendKeys(username);
    }

    public void enterPassword(String password) {
        password_id.clear();
        password_id.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton_name.click();
    }

    public void verifyLoginErrorMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(loginError_xpath));

        loginError_xpath.isDisplayed();
    }


}
