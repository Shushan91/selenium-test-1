import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by sargis on 12/11/17
 */
public class LoginTest {
    private ChromeDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium-projects\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void login() throws InterruptedException {
        loginPage.loginWith("tomsmith", "SuperSecretPassword!");
        Thread.sleep(3000);
        assertTrue("Login was not succeed!",
                loginPage.isSuccesDisplayed());
    }

    @Test
    public void loginFail() throws InterruptedException {
        loginPage.loginWith("t7omsmith", "S7uperSecretPassword!");
        assertTrue("Login was not succeed!",
                loginPage.isErrorDisplayed());
        assertTrue("Error message is not correct!",
                loginPage.getErrorMessage().contains("Your username is invalid!"));
    }

    @Test
    public void loginSecure() throws InterruptedException {
        loginPage.loginWith("tomsmith", "SuperSecretPassword!");
        assertTrue("Login was not succeed!",
                loginPage.getUrl().contains("/secure"));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}