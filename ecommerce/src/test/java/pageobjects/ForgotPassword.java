package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassword {
    WebDriver driver;

    // Locators
    private By emailField = By.id("email_address");
    private By submitButton = By.xpath("//button[@title='Reset My Password']");
    private By successMessage = By.cssSelector(".message-success");
    private By errorMessage = By.cssSelector(".message-error");

    // Constructor
    public ForgotPassword(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElements(successMessage).size() > 0;
    }

    public boolean isErrorMessageDisplayed(String expectedMessage) {
        return driver.findElement(errorMessage).getText().contains(expectedMessage);
    }
}

