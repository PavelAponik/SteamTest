package framework.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.naming.NamingException;
public class BrowserFactory {


    public static WebDriver browserSetUp(final Browsers type){
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
        for (Browsers t : Browsers.values()){
            if (t.toString().equalsIgnoreCase(type)){
                return browserSetUp(t);
            }
        }
        throw new NamingException();
    }

    public enum Browsers{
        CHROME("chrome"),
        FIREFOX("firefox");

        public String value;

        Browsers(final String values){
            value = values;
        }
        public String toString(){
            return value;
        }
    }


}
