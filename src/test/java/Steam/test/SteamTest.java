package Steam.test;

import Steam.pages.MainPage;
import framework.webdriver.BaseTest;
import org.testng.annotations.Test;
import framework.PropertiesManager;


public class SteamTest extends BaseTest {




    @Test
    public void steamTest(){
        PropertiesManager propertiesManager = new PropertiesManager();

        MainPage mainPage = new MainPage(driver);
        mainPage.chooseLanguage(propertiesManager.getProperty(PropertiesManager.configPropertyPath, "language"));
    }
}
