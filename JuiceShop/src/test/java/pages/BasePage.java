package pages;

import framework.Constants;
import framework.ParentDriver;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage extends ParentDriver {
    //public static WebDriver driver;
    WebDriverWait wait;
    WebElement element;
    WebElement element2;
    Actions action;


    @FindBy(xpath = Constants.WELCOME_POPUP)
    WebElement welcomePopupElement;
    @FindBy(xpath = Constants.FOOTER_POPUP_BUTTON)
    WebElement footerPopupElementButton;
    @FindBy(xpath = Constants.TOPNAV_ACCOUNT_BUTTON)
    WebElement navAccountButton;
    @FindBy(xpath = Constants.TOPNAV_LOGOUT_BUTTON)
    WebElement navLogoutButton;

    //base class constructor with PageFactory initialization
    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        action = new Actions(driver);
    }

    //close the driver
    public static void teardownBaseObject() {
        driver.quit();
    }

    public void loginSuccessful() {
        element = this.waitUntilClickable(this.navAccountButton);
        element.click();

        element2 = this.waitUntilElementVisible(this.navLogoutButton);
        Assert.assertTrue(element2.isDisplayed());
        String getUrlOfThisPage = driver.getCurrentUrl();
        Assert.assertEquals(Constants.HOME_PAGE_URL, getUrlOfThisPage);
    }

    public void closeWelcomePopup() {
        boolean flag = this.waitUntilElementVisible(welcomePopupElement).isDisplayed();
        element = this.waitUntilClickable("//div[@id='cdk-overlay-1' and contains(.,'Welcome to OWASP Juice Shop!')]//button[contains(.,'Dismiss')]");
        if(flag){
            element.click();
        }

        boolean flag2 = this.waitUntilElementVisible(footerPopupElementButton).isDisplayed();
        element = this.waitUntilClickable(footerPopupElementButton);
        if(flag2){
            element.click();
        }
    }

    //Wait For An Element Until ClickAble (Explicit wait)
    public WebElement waitUntilClickable(String xpathOfTheElement) {
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathOfTheElement)));
        return element;
    }

    public WebElement waitUntilClickable(WebElement element) {
        element = wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    //WebElement
    public WebElement waitUntilElementVisible(WebElement element) {
        element = wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public boolean elementPresence(String elementLocator) {
        boolean flag;
        flag = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementLocator)));
        return false;
    }


}
