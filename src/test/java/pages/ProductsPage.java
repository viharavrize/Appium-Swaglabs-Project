package pages;

import base.AppiumBaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {

    private AndroidDriver driver;

    public ProductsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Locators
    By productsTitle = AppiumBy.accessibilityId("test-PRODUCTS");
    By productNames = AppiumBy.accessibilityId("test-Item title");
    By productPrices = AppiumBy.accessibilityId("test-Price");
    By addToCartButtons = AppiumBy.accessibilityId("test-ADD TO CART");
    By cartIcon = AppiumBy.accessibilityId("test-Cart");
    By firstProductItem = AppiumBy.accessibilityId("test-Item");

    // Actions
    public boolean isProductsPageDisplayed() {
        AppiumBaseTest.waitForVisibility(driver, productsTitle, 10);
        return driver.findElement(productsTitle).isDisplayed();
    }

    public String getFirstProductName() {
        AppiumBaseTest.waitForVisibility(driver, productNames, 10);
        return driver.findElements(productNames).get(0).getText();
    }

    public String getFirstProductPrice() {
        AppiumBaseTest.waitForVisibility(driver, productPrices, 10);
        return driver.findElements(productPrices).get(0).getText();
    }

    public void addFirstProductToCart() {
        AppiumBaseTest.waitForVisibility(driver, addToCartButtons, 10);

        List<WebElement> buttons = driver.findElements(addToCartButtons);

        if (buttons.isEmpty()) {
            throw new RuntimeException("Add to Cart button not found");
        }

        buttons.get(0).click();
    }

    public void selectFirstProduct() {
        AppiumBaseTest.waitForVisibility(driver, firstProductItem, 10);
        driver.findElement(firstProductItem).click();
    }

    public void openCart() {
        AppiumBaseTest.waitForVisibility(driver, cartIcon, 10);
        driver.findElement(cartIcon).click();
    }
}
