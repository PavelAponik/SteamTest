package Steam.test;

import Steam.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import framework.PropertiesManager;

public class SteamTest {
    public WebDriver driver;



    @Test
    public void steamTest(){
        PropertiesManager propertiesManager = new PropertiesManager();

        MainPage mainPage = new MainPage(driver);
        mainPage.chooseLanguage(propertiesManager.getProperty(PropertiesManager.configPropertyPath, "language"));
    }
}
