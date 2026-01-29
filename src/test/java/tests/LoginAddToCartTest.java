package tests;

import base.AppiumBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

public class LoginAddToCartTest extends AppiumBaseTest {

    @Test
    public void userLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        // Login
        loginPage.login("standard_user", "secret_sauce");

        // Assertion
        Assert.assertTrue(
                productsPage.isProductsPageDisplayed(),
                "Products page is not displayed after login"
        );
    }

    @Test
    public void validateProductDetailsPage() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        // Login
        loginPage.login("standard_user", "secret_sauce");

        // Capture product name on PLP
        String expectedProductName = productsPage.getFirstProductName();

        productsPage.selectFirstProduct();

        Assert.assertTrue(
                productDetailsPage.isProductDetailsPageDisplayed(),
                "Product Details page not displayed"
        );

        Assert.assertTrue(
                productDetailsPage.isProductNameDisplayed(expectedProductName),
                "Product nam eis not displayed in Product Details page"
        );
    }

    @Test
    public void addProductToCartTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        // Login
        loginPage.login("standard_user", "secret_sauce");

        // Capture product details from Products page (PLP)
        String expectedProductName = productsPage.getFirstProductName();
        String expectedProductPrice = productsPage.getFirstProductPrice();

        // Add first product to cart
        productsPage.addFirstProductToCart();

        // Open cart
        productsPage.openCart();

        // Validate product name in Cart
        Assert.assertTrue(
                cartPage.isProductNameInCartDisplayed(expectedProductName),
                "Product name is NOT displayed in Cart page"
        );

        // Validate product price in Cart
        Assert.assertTrue(
                cartPage.isProductPriceInCartDisplayed(expectedProductName, expectedProductPrice),
                "Product price is incorrect in Cart page"
        );

        System.out.println("Cart validation successful for: " + expectedProductName + " | Price: " + expectedProductPrice);
    }

    @Test
    public void removeProductFromCartTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        // Login
        loginPage.login("standard_user", "secret_sauce");

        // Add product to cart
        productsPage.addFirstProductToCart();
        productsPage.openCart();

        // Remove product
        cartPage.removeItemFromCart();

        // Assertion
        Assert.assertTrue(
                cartPage.isCartEmpty(),
                "Cart is not empty after removing the product"
        );
    }
}
