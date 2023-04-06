package framework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Constants {
    //credentials
    public static final String token = "";

    //urls
    //public static final String validateWtaDomain = "https://easycare.kaz.com.bd/swagger/index.html";
    public static final String LOGIN_PAGE_URL = "https://juice-shop.herokuapp.com/#/login";
    public static final String HOME_PAGE_URL = "https://juice-shop.herokuapp.com/#/search";
    public static final String BASKET_PAGE_URL = "https://juice-shop.herokuapp.com/#/basket";
    public static final String CHECKOUT_PAGE_URL = "https://juice-shop.herokuapp.com/#/address/select";
    public static final String CEATE_ADDRESS_PAGE_URL = "https://juice-shop.herokuapp.com/#/address/create";
    public static final String DELIVERY_PAGE_URL = "https://juice-shop.herokuapp.com/#/delivery-method";

    //xpaths
    public static final String WELCOME_POPUP = "//div[@id='cdk-overlay-1' and contains(.,'Welcome to OWASP Juice Shop!')]";
    public static final String FOOTER_POPUP_BUTTON = "(//div[@role='dialog']//a[@role='button' and contains(.,'Me want it!')])[1]";
    public static final String LOGIN_USERNAME_TEXTFIELD_XPATH = "//div[@id='login-form']//input[@id='email']";
    public static final String LOGIN_PASSWORD_TEXTFIELD_XPATH = "//div[@id='login-form']//input[@id='password']";
    public static final String LOGIN_BUTTON = "//div[@id='login-form']//button[@id='loginButton']";

    public static final String TOPNAV_ACCOUNT_BUTTON = "//app-navbar/mat-toolbar//button[@id='navbarAccount']";
    public static final String TOPNAV_LOGOUT_BUTTON = "//button[@id='navbarLogoutButton']";

}
