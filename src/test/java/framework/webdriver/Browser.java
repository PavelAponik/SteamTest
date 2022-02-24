package framework.webdriver;

import framework.PropertiesResourceManager;
import org.openqa.selenium.WebDriver;
import org.testng.util.Strings;

import javax.naming.NamingException;

public class Browser {


    static final String PROPERTIES_FILE = "config.properties";
    private static final String BROWSER_PROP = "browser";
    private static final String BROWSER_BY_DEFAULT = "chrome";

    public static PropertiesResourceManager props;
    public static Browsers currentBrowser;
    private static Browser instance;
    private static WebDriver driver;



    private Browser(){
        currentBrowser.toString();
    }

    public static Browser getInstance(){
        if(instance == null) {
            initProperties();
            try {
                driver = BrowserFactory.browserSetUp(currentBrowser.toString());
            } catch (NamingException e) {
                e.printStackTrace();
            }
            instance = new Browser();
        }
        return instance;
    }

    public void exit(){
        try {
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            instance = null;
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

    public void windowMaximaze(){
        try{
            driver.manage().window().maximize();
        } catch (Exception e){}
    }

    public void navigate(final String url){
        driver.navigate().to(url);
    }


    public boolean isBrowserAlive(){
        return instance != null;
    }
}
