package pageobjects;

import org.omg.PortableInterceptor.ServerRequestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Shush&Gar on 14-Dec-17.
 */
public class LoginPage extends BasePage {
    private WebDriver driver;
    private String loginUrl="http://the-internet.herokuapp.com/login";
    private By usernameLocator =By.id("username");
    private By passwordLocator =By.id("password");
    private By submitLocator = By.cssSelector("#login button");
    private By successLocator = By.cssSelector(".flash.success");
    private By errorLocator= By.cssSelector(".flash.error");

    public LoginPage (WebDriver webDriver) {
        super(webDriver);
        visit(loginUrl);
    }

    public  String getUrl(){
        return driver.getCurrentUrl();
    }

    public void loginWith (String username, String password) {
        find(usernameLocator).sendKeys(username);
        find(passwordLocator).sendKeys(password);
        find(submitLocator).click();
        driver.get(loginUrl);
    }

     public boolean isSuccesDisplayed() {

       return find(successLocator).isDisplayed();

    }

      public boolean isErrorDisplayed() {
            return find(errorLocator).isDisplayed();
        }
        public  String getErrorMessage () {
            return find(errorLocator).getText();
        }
    }




