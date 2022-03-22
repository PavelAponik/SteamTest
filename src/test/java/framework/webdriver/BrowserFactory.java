package framework.webdriver;

import framework.PropertiesManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;

public class BrowserFactory {

    public static String browser;

    public static WebDriver browserSetUp(final String browser){
        WebDriver driver = null;
        PropertiesManager propertiesManager = new PropertiesManager();
        //browser = propertiesManager.getProperty(PropertiesManager.configPropertyPath, "browser");

        switch (browser){
            case "chrome":
                HashMap<String, Object> chromePrefs = new HashMap<>();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.default_directory", System.getProperty("user.dir") + propertiesManager.getProperty(PropertiesManager.configPropertyPath, "download_directory"));
                chromePrefs.put("safebrowsing.enabled", "true");
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", chromePrefs);
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("browser.download.folderList", 2);
                profile.setPreference("browser.download.dir",System.getProperty("user.dir") + propertiesManager.getProperty(PropertiesManager.configPropertyPath, "download_directory"));
                profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/csv, text/csv, text/plain,application/octet-stream doc xls pdf txt");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions.setProfile(profile));
                break;
            default:
                break;
        }
        return driver;
    }

}
