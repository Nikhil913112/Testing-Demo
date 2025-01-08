package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);

        // Navigate to the login page
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");

        // Perform login
        loginPage.enterEmail("valid.user@example.com");
        loginPage.enterPassword("ValidPassword123");
        loginPage.clickLoginButton();

        // Verify successful login (e.g., by checking for a logout button or user dashboard)
        Assert.assertTrue(loginPage.isDashboardDisplayed(), "Login failed with valid credentials!");
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);

        // Navigate to the login page
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");

        // Attempt login with invalid credentials
        loginPage.enterEmail("invalid.user@example.com");
        loginPage.enterPassword("InvalidPassword");
        loginPage.clickLoginButton();

        // Verify error message is displayed
        Assert.assertTrue(loginPage.isErrorMessageDisplayed("Invalid login or password."), "Error message not displayed for invalid login!");
    }
}