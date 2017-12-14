package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Shush&Gar on 14-Dec-17.
 */
public class BasePage {
    private WebDriver driver;
    public  BasePage (WebDriver webDriver){
        this.driver=webDriver;
    }


    public void visit (String url) {
        driver.get(url);
    }
    public WebElement find(By locator){
      return driver.findElement(locator);
    }
}
