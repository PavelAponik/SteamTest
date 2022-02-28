package framework.webdriver;

import framework.PropertiesManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static String browser;

    public static WebDriver browserSetUp(){
        WebDriver driver = null;
        PropertiesManager propertiesManager = new PropertiesManager();
        browser = propertiesManager.getProperty(PropertiesManager.configPropertyPath, "browser");

        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                break;
        }
        return driver;
    }

}
