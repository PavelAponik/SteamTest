package framework.webdriver;

import framework.PropertiesResourceManager;
import org.openqa.selenium.WebDriver;
import org.testng.util.Strings;

import javax.naming.NamingException;
import java.util.Locale;

public class Browser {


    static final String PROPERTIES_FILE = "config.properties";
    private static final String BROWSER_PROP = "browser";
    private static final String BROWSER_BY_DEFAULT = "chrome";

    public static PropertiesResourceManager props;
    public static BrowserFactory currentBrowser;
    private static Browser browserInstance;
    private static WebDriver driver;

    public static Browser.Browsers currentBrowser;

    private Browser(){
        currentBrowser.toString();
    }

    public static Browser getInstance(){
        if(browserInstance == null) {
            initProperties();
            try {
                driver = BrowserFactory.browserSetUp(currentBrowser.toString());
            } catch (NamingException e) {
                e.printStackTrace();
            }
            browserInstance = new Browser();
        }
        return browserInstance;
    }

    public void exit(){
        try {
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            browserInstance = null;
        }
    }

    private static void initProperties(){
        props = new PropertiesResourceManager(PROPERTIES_FILE);

        if (Strings.isNotNullAndNotEmpty(props.getProperty(BROWSER_PROP))){
            currentBrowser = Browsers.valueOf(System.getProperty(BROWSER_PROP, BROWSER_BY_DEFAULT).toUpperCase());
        }else {
            String proper = props.getProperty(BROWSER_PROP);
            currentBrowser = Browsers.valueOf(proper.toUpperCase());
        }


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
