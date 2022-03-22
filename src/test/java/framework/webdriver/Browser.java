package framework.webdriver;

import framework.PropertiesManager;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

import static framework.webdriver.BrowserFactory.browser;
import static framework.webdriver.BrowserFactory.browserSetUp;

public class Browser {

    public static PropertiesManager propertyManager = new PropertiesManager();
    public static WebDriver driver;

    public static void setUp(){
        driver = browserSetUp(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(propertyManager.getProperty(PropertiesManager.configPropertyPath, "implicit_wait")), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(propertyManager.getProperty(PropertiesManager.configPropertyPath, "implicit_wait")), TimeUnit.SECONDS);
        driver.get(propertyManager.getProperty(PropertiesManager.configPropertyPath, "url"));
    }

    public static void tearDown(){
        driver.quit();
    }
}
