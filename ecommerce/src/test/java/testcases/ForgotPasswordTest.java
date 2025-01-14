package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

public class ForgotPasswordTest extends BaseTest {

    // Method to enter an email in the email field
    public void enterEmail(String email) {
        driver.findElement(By.id("email_address")).sendKeys(email);
    }

    // Method to click the submit button
    public void clickSubmitButton() {
        driver.findElement(By.cssSelector("button[title='Submit']")).click();
    }

    // Method to check if the success message is displayed
    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(By.cssSelector(".success-msg")).isDisplayed();
    }

    // Method to check if an error message is displayed
    public boolean isErrorMessageDisplayed(String expectedMessage) {
        String actualMessage = driver.findElement(By.cssSelector(".error-msg")).getText();
        return actualMessage.contains(expectedMessage);
    }

    @Test
    public void testValidEmail() {
        // Navigate to the forgot password page
        driver.get("https://magento.softwaretestingboard.com/customer/account/forgotpassword/");

        // Enter a valid email address
        enterEmail("valid.user@example.com");
        clickSubmitButton();

        // Verify success message is displayed
        Assert.assertTrue(isSuccessMessageDisplayed(), "Success message not displayed for valid email!");
    }

    @Test
    public void testInvalidEmail() {
        // Navigate to the forgot password page
        driver.get("https://magento.softwaretestingboard.com/customer/account/forgotpassword/");

        // Enter an invalid email address
        enterEmail("invalid.email@example.com");
        clickSubmitButton();

        // Verify error message is displayed
        Assert.assertTrue(isErrorMessageDisplayed("Please enter a valid email address"), "Error message not displayed for invalid email!");
    }

    @Test
    public void testEmptyEmail() {
        // Navigate to the forgot password page
        driver.get("https://magento.softwaretestingboard.com/customer/account/forgotpassword/");

        // Leave the email field empty and submit
        clickSubmitButton();

        // Verify error message is displayed
        Assert.assertTrue(isErrorMessageDisplayed("This is a required field."), "Error message not displayed for empty email field!");
    }
}