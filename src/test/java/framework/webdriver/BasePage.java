package framework.webdriver;

import framework.PropertiesManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.function.Function;

import static framework.webdriver.Browser.propertyManager;

public abstract class BasePage {

    WebDriverWait wait= new WebDriverWait(driver, Integer.parseInt(propertyManager.getProperty(PropertiesManager.configPropertyPath,
            "explicit_wait")));
    public static WebDriver driver = Browser.driver;

    public void waitUntilExpectedConditions(Function expectedConditions){
        wait.until(expectedConditions);
    }

    public void changeTab(){
        for (String windowHandle : driver.getWindowHandles()) {
            if(!driver.getWindowHandle().contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
