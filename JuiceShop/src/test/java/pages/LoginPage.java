package pages;

import framework.Constants;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    @FindBy(xpath = Constants.LOGIN_USERNAME_TEXTFIELD_XPATH)
    WebElement usernameTextField;

    @FindBy(xpath = Constants.LOGIN_PASSWORD_TEXTFIELD_XPATH)
    WebElement passwordTextField;

    @FindBy(xpath = Constants.LOGIN_BUTTON)
    WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void verifyBrowserIsOpen(){
        Assert.assertFalse(driver.toString().contains("null"));
    }
    public void navigateToLoginPage() {
        driver.navigate().to(Constants.LOGIN_PAGE_URL);
    }

    public void enterUsername(@NotNull String userName) {
        element = waitUntilElementVisible(usernameTextField);
        element.sendKeys(userName);
    }

    public void enterPassword(@NotNull String password) {
        element = waitUntilElementVisible(passwordTextField);
        element.sendKeys(password);
    }

    public void clickLoginButton() {
        element = waitUntilClickable(signInButton);
        element.click();
    }
}
