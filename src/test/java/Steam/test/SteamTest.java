package Steam.test;

import Steam.pages.*;
import framework.webdriver.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.testng.annotations.Test;
import framework.PropertiesManager;
import org.testng.asserts.SoftAssert;


public class SteamTest extends BaseTest {

    static MainPage mainPage;
    static CategoryPage categoryPage;
    static AgeCheckPage ageCheckPage;
    static GamePage gamePage;
    static AboutPage aboutPage;
    static PropertiesManager propertiesManager;
    static SoftAssert softAssert;


    @Test
    public void steamTest(){
        propertiesManager = new PropertiesManager();
        softAssert = new SoftAssert();

        mainPage = new MainPage(driver);
        mainPage.chooseLanguage(propertiesManager.getProperty(PropertiesManager.configPropertyPath, "language"));
        softAssert.assertEquals(driver.getTitle(), propertiesManager.getProperty(MainPage.currentLanguage, "main_Page_Title"));
        mainPage.menuNavigation(propertiesManager.getProperty(MainPage.currentLanguage, "main_Menu_Item"),
                propertiesManager.getProperty(MainPage.currentLanguage, "main_Menu_SubItem"));

        categoryPage = new CategoryPage(driver);
        softAssert.assertEquals(driver.getTitle(), propertiesManager.getProperty(MainPage.currentLanguage, "category_Page_Title") );
        categoryPage.searchForBestDiscount();

        ageCheckPage = new AgeCheckPage(driver);
        if(ageCheckPage.isCheckAgePageOpened()){
            ageCheckPage.selectAge(propertiesManager.getProperty(PropertiesManager.configPropertyPath, "year"));
        }

        gamePage = new GamePage(driver);
        //softAssert.assertEquals(driver.getTitle()), CategoryPage.);
        gamePage.clickIstallSteam();

        aboutPage = new AboutPage(driver);
        softAssert.assertEquals(driver.getTitle(), propertiesManager.getProperty(MainPage.currentLanguage,"about_Page_Title"));



    }
}
