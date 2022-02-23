package framework.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.naming.NamingException;
public abstract class BrowserFactory {


    public static WebDriver browserSetUp(final Browser.Browsers type){
        WebDriver driver = null;

        switch (type){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                break;
        }
        return driver;
    }

    public static WebDriver browserSetUp(final String type) throws NamingException{
        for (Browser.Browsers t : Browser.Browsers.values()){
            if (t.toString().equalsIgnoreCase(type)){
                return browserSetUp(t);
            }
        }
        throw new NamingException();
    }


}
