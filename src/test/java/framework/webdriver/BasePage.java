package framework.webdriver;

import framework.PropertiesManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.function.Function;

import static framework.webdriver.Browser.propertyManager;
import static framework.webdriver.BrowserFactory.browserSetUp;

public abstract class BasePage {

    public static WebDriver driver = browserSetUp();
    public WebDriverWait wait;


    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void waitUntilExpectedConditions(Function expectedConditions){
        WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(propertyManager.getProperty(PropertiesManager.configPropertyPath,
                "explicit_wait")));
        wait.until(expectedConditions);
    }

}
