package pages;

import base.AppiumBaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CartPage {

    private AndroidDriver driver;

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Locators
    By cartItemName = AppiumBy.accessibilityId("test-Item title");
    By cartItemPrice = AppiumBy.accessibilityId("test-Price");
    By removeButton = AppiumBy.accessibilityId("test-REMOVE");

    public void removeItemFromCart() {
        AppiumBaseTest.waitForVisibility(driver, removeButton, 10);
        driver.findElement(removeButton).click();
    }

    public boolean isCartEmpty() {
        return driver.findElements(cartItemName).isEmpty();
    }

    // Check if a specific product name is displayed in the cart
    public boolean isProductNameInCartDisplayed(String productName) {
        try {
            By productLocator = AppiumBy.xpath("//android.widget.TextView[@text='" + productName + "']");
            AppiumBaseTest.waitForVisibility(driver, productLocator, 10);
            return driver.findElement(productLocator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Check if a specific product price is displayed in the cart for a given product
    public boolean isProductPriceInCartDisplayed(String productName, String productPrice) {
        try {
            By priceLocator = AppiumBy.xpath("//android.widget.TextView[@text='" + productPrice + "']");
            AppiumBaseTest.waitForVisibility(driver, priceLocator, 10);
            return driver.findElement(priceLocator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
