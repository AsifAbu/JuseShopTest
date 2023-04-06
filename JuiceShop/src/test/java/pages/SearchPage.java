package pages;

import framework.Constants;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
    WebElement element;

    @FindBy(xpath = "//app-navbar/mat-toolbar//mat-search-bar[@id='searchQuery']")
    WebElement topNavSearchButton;

    @FindBy(xpath = "//app-navbar/mat-toolbar//mat-search-bar[@id='searchQuery']//input[@id='mat-input-0']")
    WebElement topNavSearchField;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void verifySearchButton() {
        element = this.waitUntilElementVisible(topNavSearchButton);
        element.click();
    }
    public void search() {
        element = this.waitUntilElementVisible(topNavSearchButton);
        element.click();
        element = this.waitUntilElementVisible(topNavSearchField);
        element.sendKeys("apple");
        element.sendKeys(Keys.ENTER);
        int appleResultCount = 0;

        //verify search by 'Apple', result count is 2
        appleResultCount = driver.findElements(By.xpath("//mat-card//div[@class='item-name' and contains(.,'Apple')]")).size();
        Assert.assertEquals(2,appleResultCount);

        //verify search by 'Banana', result count is 0
        appleResultCount = driver.findElements(By.xpath("//mat-card//div[@class='item-name' and contains(.,'Banana')]")).size();
        Assert.assertEquals(0,appleResultCount);
    }

    public void verifySearchResult() {
        int appleResultCount = 0;

        //verify search by 'Apple', result count is 2
        appleResultCount = driver.findElements(By.xpath("//mat-card//div[@class='item-name' and contains(.,'Apple')]")).size();
        Assert.assertEquals(2,appleResultCount);

        //verify search by 'Banana', result count is 0
        appleResultCount = driver.findElements(By.xpath("//mat-card//div[@class='item-name' and contains(.,'Banana')]")).size();
        Assert.assertEquals(0,appleResultCount);
    }

}
