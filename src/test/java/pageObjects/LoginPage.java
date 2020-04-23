package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import tests.BaseTest;

import java.time.Duration;

public class LoginPage extends BasePage {
    private final String emailXpath = "//*[@type='email']";
    private final String passwordXpath = "//*[@type='password']";
    private final String loginButtonXpath = "//*[@type='submit']";
    private final String url = "https://koelapp.testpro.io/";
    private final String errorXpath = "//*[@class='error']";
    private WebDriver driver;
    FluentWait<WebDriver> fluentWait;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(url);
    }

    public WebElement getEmailField() {
        return driver.findElement(By.xpath(emailXpath));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.xpath(passwordXpath));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.xpath(loginButtonXpath));
    }

    public HomePage login(String email, String password) {
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
        return new HomePage(driver);
    }

    public boolean isError() {
        try {
            fluentWait.until(x -> x.findElement(By.xpath(errorXpath)));
        } catch (TimeoutException err) {
            return false;
        }
        return true;
    }
}
