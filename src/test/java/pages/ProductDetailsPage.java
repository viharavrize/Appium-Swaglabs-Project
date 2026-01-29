package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import base.AppiumBaseTest;

public class ProductDetailsPage {

    private AndroidDriver driver;

    public ProductDetailsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // PDP-only locators
    By backButton = AppiumBy.accessibilityId("test-BACK TO PRODUCTS");
    By productPrice = AppiumBy.accessibilityId("test-Price");
    By addToCartButton = AppiumBy.accessibilityId("test-ADD TO CART");

    public boolean isProductDetailsPageDisplayed() {
        try {
            AppiumBaseTest.waitForVisibility(driver, backButton, 10);
            return driver.findElement(backButton).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isProductNameDisplayed(String productName) {
        try {
            By productNameLocator = MobileBy.xpath("//android.widget.TextView[@text='" + productName + "']");
            return driver.findElement(productNameLocator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
