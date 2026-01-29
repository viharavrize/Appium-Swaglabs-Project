package pages;

import base.AppiumBaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class LoginPage {

    private AndroidDriver driver;

    // Constructor to initialize driver
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Locators for login
    private By usernameField = AppiumBy.accessibilityId("test-Username");
    private By passwordField = AppiumBy.accessibilityId("test-Password");
    private By loginButton   = AppiumBy.accessibilityId("test-LOGIN");
    private By productsLabel = AppiumBy.accessibilityId("test-PRODUCTS"); // for post-login validation

    // Login method
    public void login(String username, String password) {
        AppiumBaseTest.waitForVisibility(driver, usernameField, 10);
        driver.findElement(usernameField).sendKeys(username);

        AppiumBaseTest.waitForVisibility(driver, passwordField, 10);
        driver.findElement(passwordField).sendKeys(password);

        AppiumBaseTest.waitForVisibility(driver, loginButton, 10);
        driver.findElement(loginButton).click();

        AppiumBaseTest.waitForVisibility(driver, productsLabel, 10);
        boolean isDisplayed = driver.findElement(productsLabel).isDisplayed();
        System.out.println("Products page displayed: " + isDisplayed);
    }

}
