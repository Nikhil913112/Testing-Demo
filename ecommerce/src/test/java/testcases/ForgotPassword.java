package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import utils.BaseTest;

public class ForgotPassword extends BaseTest {

    @Test
    public void testValidEmail() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        // Navigate to the forgot password page
        driver.get("https://magento.softwaretestingboard.com/customer/account/forgotpassword/");

        // Enter a valid email address
        forgotPasswordPage.enterEmail("valid.user@example.com");
        forgotPasswordPage.clickSubmitButton();

        // Verify success message is displayed
        Assert.assertTrue(forgotPasswordPage.isSuccessMessageDisplayed(), "Success message not displayed for valid email!");
    }

    @Test
    public void testInvalidEmail() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        // Navigate to the forgot password page
        driver.get("https://magento.softwaretestingboard.com/customer/account/forgotpassword/");

        // Enter an invalid email address
        forgotPasswordPage.enterEmail("invalid.email@example.com");
        forgotPasswordPage.clickSubmitButton();

        // Verify error message is displayed
        Assert.assertTrue(forgotPasswordPage.isErrorMessageDisplayed("Please enter a valid email address"), "Error message not displayed for invalid email!");
    }

    @Test
    public void testEmptyEmail() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        // Navigate to the forgot password page
        driver.get("https://magento.softwaretestingboard.com/customer/account/forgotpassword/");

        // Leave the email field empty and submit
        forgotPasswordPage.enterEmail("");
        forgotPasswordPage.clickSubmitButton();

        // Verify error message is displayed
        Assert.assertTrue(forgotPasswordPage.isErrorMessageDisplayed("This is a required field."), "Error message not displayed for empty email field!");
    }
}
