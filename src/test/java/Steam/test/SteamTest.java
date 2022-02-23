package Steam.test;

import framework.PropertiesResourceManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SteamTest {
    public WebDriver driver;


    @Test
    public void driverSetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(PropertiesResourceManager.getProperty("url"));
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
