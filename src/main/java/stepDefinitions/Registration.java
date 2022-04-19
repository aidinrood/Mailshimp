package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Registration extends BaseClass {

    public WebDriver driver;

    public BaseClass baseClass;

    public Registration(BaseClass baseClass) {
        this.baseClass = baseClass;
        this.driver = baseClass.driver;
    }

    @Given("User is on landing page")
    public void user_is_on_landing_page() {
        Assert.assertTrue("Verify that user is on sign up page", driver.getTitle().equals("Signup | Mailchimp"));
    }

    @When("User enter email as {string}")
    public void user_enter_email_as(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    @When("User enter username as {string}")
    public void user_enter_username_as(String username) {
        driver.findElement(By.id("new_username")).sendKeys(username);
    }

    @When("User enter password as {string}")
    public void user_enter_password_as(String password) {
        driver.findElement(By.id("new_password")).sendKeys(password);
    }

    @When("User click on Sign Up")
    public void user_click_on_sign_up() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("create-account")));
        driver.findElement(By.id("create-account")).click();
    }

    @Then("Verify if data is correct then user should be able to register")
    public void verify_if_data_is_correct_then_user_should_be_able_to_register() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("signup-wrap"))));
        Assert.assertTrue("Verify that user is able to register.", driver.getTitle().equals("Success | Mailchimp"));
    }

    @Then("Verify error {string} for already existing username is displayed")
    public void verify_error_something_for_already_existing_username_is_displayed(String errorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement usernameErrorElement = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name=\"username\"]//following-sibling::span"))));
        Assert.assertTrue("Verify that user already exist error is displayed.", usernameErrorElement.getText().equals(errorMessage));
    }

    @Then("Verify error {string} for missing email is displayed")
    public void verify_error_something_for_missing_email_is_displayed(String errorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement usernameErrorElement = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name=\"email\"]//following-sibling::span"))));
        Assert.assertTrue("Verify that user already exist error is displayed.", usernameErrorElement.getText().equals(errorMessage));
    }

    @Then("Verify error {string} for user name greater than 100 characters is displayed")
    public void verify_error_something_for_user_name_greater_than_100_characters_is_displayed(String errorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement usernameErrorElement = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name=\"username\"]//following-sibling::span"))));
        Assert.assertTrue("Verify that username is having more than 100 characters error is displayed.", usernameErrorElement.getText().equals(errorMessage));
    }

}
