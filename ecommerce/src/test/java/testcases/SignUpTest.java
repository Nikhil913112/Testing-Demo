package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.SignUpPage;

public class SignUpTest extends BaseTest {

    @Test
    public void testSignUp() {
        SignUpPage signUpPage = new SignUpPage(driver);

        // Navigate to the sign-up page
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");

        // Fill out the sign-up form
        signUpPage.enterFirstName("John");
        signUpPage.enterLastName("Doe");
        signUpPage.enterEmail("john.doe@example.com");
        signUpPage.enterPassword("Password123");
        signUpPage.enterConfirmPassword("Password123");

        // Submit the form
        signUpPage.clickCreateAccountButton();

        // Verify successful sign-up (assuming success message is displayed)
        Assert.assertTrue(signUpPage.isSuccessMessageDisplayed(), "Sign-up failed!");
    }

    @Test
    public void testEmptyFirstName() {
        SignUpPage signUpPage = new SignUpPage(driver);
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        signUpPage.enterLastName("Doe");
        signUpPage.enterEmail("john.doe@example.com");
        signUpPage.enterPassword("Password123");
        signUpPage.enterConfirmPassword("Password123");
        signUpPage.clickCreateAccountButton();
        Assert.assertTrue(signUpPage.isErrorDisplayed("First Name is required"), "Error message for empty first name is not displayed!");
    }

    @Test
    public void testInvalidEmailFormat() {
        SignUpPage signUpPage = new SignUpPage(driver);
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        signUpPage.enterFirstName("John");
        signUpPage.enterLastName("Doe");
        signUpPage.enterEmail("invalid-email");
        signUpPage.enterPassword("Password123");
        signUpPage.enterConfirmPassword("Password123");
        signUpPage.clickCreateAccountButton();
        Assert.assertTrue(signUpPage.isErrorDisplayed("Please enter a valid email address"), "Error message for invalid email format is not displayed!");
    }

    @Test
    public void testPasswordMismatch() {
        SignUpPage signUpPage = new SignUpPage(driver);
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        signUpPage.enterFirstName("John");
        signUpPage.enterLastName("Doe");
        signUpPage.enterEmail("john.doe@example.com");
        signUpPage.enterPassword("Password123");
        signUpPage.enterConfirmPassword("Password456");
        signUpPage.clickCreateAccountButton();
        Assert.assertTrue(signUpPage.isErrorDisplayed("Passwords do not match"), "Error message for password mismatch is not displayed!");
    }

    @Test
    public void testWeakPassword() {
        SignUpPage signUpPage = new SignUpPage(driver);
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        signUpPage.enterFirstName("John");
        signUpPage.enterLastName("Doe");
        signUpPage.enterEmail("john.doe@example.com");
        signUpPage.enterPassword("123");
        signUpPage.enterConfirmPassword("123");
        signUpPage.clickCreateAccountButton();
        Assert.assertTrue(signUpPage.isErrorDisplayed("Minimum length of this field must be equal or greater than 8 symbols"), "Error message for weak password is not displayed!");
    }
}