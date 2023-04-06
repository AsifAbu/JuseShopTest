package pages;

import framework.Constants;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderPage extends BasePage{
    WebElement element;

    @FindBy(xpath = "(//mat-card//button[contains(@class, 'btn-basket') and contains(.,'Add to Basket')])[1]")
    WebElement addToBasketButton;

    @FindBy(xpath = "//simple-snack-bar")
    WebElement addToBasketSuccessAlert;

    @FindBy(xpath = "//button[@routerlink='/basket']")
    WebElement basketButton;

    @FindBy(xpath = "//button[@id='checkoutButton']")
    WebElement checkoutButton;

    @FindBy(xpath = "//button[@routerlink='/address/create']/span[@class='mat-button-wrapper']")
    WebElement addAddressButton;

    @FindBy(xpath = "(//mat-card//input[contains(@data-placeholder,'Please provide a country')])[1]")
    WebElement addressCountryField;
    @FindBy(xpath = "(//mat-card//input[contains(@data-placeholder,'Please provide a name')])[1]")
    WebElement addressNameField;
    @FindBy(xpath = "(//mat-card//input[contains(@data-placeholder,'Please provide a mobile number')])[1]")
    WebElement addressMobileField;
    @FindBy(xpath = "(//mat-card//input[contains(@data-placeholder,'Please provide a ZIP code')])[1]")
    WebElement addressZipField;
    @FindBy(xpath = "(//mat-card//textarea[@id='address'])[1]")
    WebElement addressAddressField;
    @FindBy(xpath = "(//mat-card//input[contains(@data-placeholder,'Please provide a city')])[1]")
    WebElement addressCityField;
    @FindBy(xpath = "(//mat-card//input[contains(@data-placeholder,'Please provide a state')])[1]")
    WebElement addressStateField;
    @FindBy(xpath = "(//mat-card//button[@id='submitButton'])[1]")
    WebElement addressSubmitButton;
    @FindBy(xpath = "(//mat-table/mat-row/mat-cell[2][contains(.,'AsifHome')])[1]")
    WebElement addressNameAssert;
    @FindBy(xpath = "(//button/span[contains(.,'Continue')])[1]")
    WebElement addressContinueButton;


    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void verifyUserIsOnHomePage() {
        driver.navigate().to(Constants.HOME_PAGE_URL);
        String getUrlOfThisPage = driver.getCurrentUrl();
        Assert.assertEquals(Constants.HOME_PAGE_URL, getUrlOfThisPage);
    }

    public void addOneItemToBasket() {
        element = this.waitUntilElementVisible(addToBasketButton);
        element.click();
        wait.until(ExpectedConditions.invisibilityOf(addToBasketSuccessAlert));
    }

    public void clickOnTheBasketButton() {
        element = this.waitUntilElementVisible(basketButton);
        element.click();
        String getUrlOfThisPage = driver.getCurrentUrl();
        Assert.assertEquals(Constants.BASKET_PAGE_URL, getUrlOfThisPage);
    }

    public void verifyAddItem() {
        int elementCount= driver.findElements(By.xpath("//mat-row//img")).size();
        Assert.assertEquals(1, elementCount);
    }

    public void clickCheckoutButton() {
        element = this.waitUntilElementVisible(checkoutButton);
        element.click();
    }

    public void verifyCheckoutPage() {
        String getUrlOfThisPage = driver.getCurrentUrl();
        Assert.assertEquals(Constants.CHECKOUT_PAGE_URL, getUrlOfThisPage);
    }

    public void clickAddressButton() {
        element = this.waitUntilElementVisible(addAddressButton);
        element.click();
        String getUrlOfThisPage = driver.getCurrentUrl();
        Assert.assertEquals(Constants.CEATE_ADDRESS_PAGE_URL, getUrlOfThisPage);
    }

    public void createAddress() {
        element = this.waitUntilElementVisible(addressCountryField);
        element.sendKeys("Bangladesh");

        element = this.waitUntilElementVisible(addressNameField);
        element.sendKeys("AsifHome");

        element = this.waitUntilElementVisible(addressMobileField);
        element.sendKeys("01780963777");

        element = this.waitUntilElementVisible(addressZipField);
        element.sendKeys("1212");

        element = this.waitUntilElementVisible(addressAddressField);
        element.sendKeys("Gulshan");

        element = this.waitUntilElementVisible(addressCityField);
        element.sendKeys("Dhaka");

        element = this.waitUntilElementVisible(addressStateField);
        element.sendKeys("State 1");

        element = this.waitUntilElementVisible(addressSubmitButton);
        element.click();

        element = this.waitUntilElementVisible(addressNameAssert);
        String addressNameVerify = element.getText();

        Assert.assertEquals("AsifHome", addressNameVerify);
    }

    public void selectCreatedAddress() {
        element = this.waitUntilElementVisible(addressNameAssert);
        element.click();
    }

    public void addressContinue() {
        element = this.waitUntilElementVisible(addressContinueButton);
        element.click();
        String getUrlOfThisPage = driver.getCurrentUrl();
        Assert.assertEquals(Constants.DELIVERY_PAGE_URL, getUrlOfThisPage);
    }

}
