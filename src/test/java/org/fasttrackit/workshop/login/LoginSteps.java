package org.fasttrackit.workshop.login;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;
import org.fasttrackit.util.TestBaseNative;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LoginSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);
    public static final String VALID_EMAIL = "eu@fast.com";
    public static final String VALID_PASSWORD = "eu.pass";

    private LoginView loginPage = new LoginView();

    @Given("^I access the login page$")
    public void I_access_the_login_page() {
        driver.get("file:///F:/Installers/installers/backup/app-demo/login.html");
    }

    @Given("^I insert valid credentials$")
    public void I_insert_valid_credentials() {
        loginPage.enterCredentials(VALID_EMAIL, VALID_PASSWORD);
    }

    @When("^I click login button$")
    public void I_click_login_button() {
        loginPage.clickOnLoginButton();
    }

    @Then("^I check if user was logged in$")
    public void I_check_if_user_was_logged_in() {
        WebElement logout = driver.findElement(By.linkText("Logout"));
        boolean successLoggedin = logout.isDisplayed();
        assertThat("Could not find logout button", successLoggedin, is(true));
    }

    @Given("^I insert invalid credentials$")
    public void I_insert_invalid_credentials() {
        loginPage.enterCredentials("aa@fast.com", "aa.pass");
        I_enter_credentials("aa@fast.com", "aa.pass");
    }

    @Then("^I expect invalid credential message$")
    public void I_expect_invalid_credential_message() {
        loginPage.errorMessageShouldBePresent("Invalid user or password!");
    }


    @When("^I enter \"([^\"]*)\"/\"([^\"]*)\" credentials$")
    public void I_enter_credentials(String emailValue, String passValue) {
        loginPage.enterCredentials(emailValue, passValue);
    }

    @Then("^I expect \"([^\"]*)\" error message$")
    public void I_expect_error_message(String expectedMessage) {
        loginPage.errorMessageShouldBePresent(expectedMessage);
    }

    @Given("^I successfully login$")
    public void I_successfully_login() {
        I_access_the_login_page();
        I_insert_valid_credentials();
        I_click_login_button();
        I_check_if_user_was_logged_in();
    }
}
