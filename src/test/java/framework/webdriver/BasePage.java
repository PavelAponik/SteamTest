package framework.webdriver;

import framework.PropertiesManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

import static framework.webdriver.Browser.propertyManager;

public abstract class BasePage {

    public WebDriver driver;
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
