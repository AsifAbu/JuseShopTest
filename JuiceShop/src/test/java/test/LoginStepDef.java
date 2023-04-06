package test;

import framework.ParentScenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class LoginStepDef extends ParentScenario {

    @Given("browser is open")
    public void browser_is_open() {
        loginPage.verifyBrowserIsOpen();
    }

    @Then("go to the login page")
    public void go_to_the_login_page() {
        loginPage.navigateToLoginPage();
    }

    @Then("welcome popup came, close the popup")
    public void welcome_popup_came_close_the_popup() {
        basePage.closeWelcomePopup();
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("user enters email {string}")
    public void user_enters_email(String username) {
        loginPage.enterUsername(username);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
        loginPage.enterPassword(password);
    }

    @And("click on login button")
    public void click_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        basePage.loginSuccessful();
    }

}
