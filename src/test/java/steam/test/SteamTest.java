package steam.test;

import steam.pages.*;
import framework.webdriver.BaseTest;
import framework.webdriver.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import framework.PropertiesManager;
import org.testng.asserts.SoftAssert;

import static framework.webdriver.BasePage.driver;

public class SteamTest extends BaseTest {

    static MainPage mainPage;
    static CategoryPage categoryPage;
    static AgeCheckPage ageCheckPage;
    static GamePage gamePage;
    static DownloadPage downloadPage;
    static PropertiesManager propertiesManager;
    static SoftAssert softAssert;

    @BeforeTest
    public void trashClean(){
        DownloadPage downloadPage = new DownloadPage();
        downloadPage.deleteFile(downloadPage.isFilePresent());
    }

    @Test
    public void steamTest(){
        propertiesManager = new PropertiesManager();
        softAssert = new SoftAssert();
        logger = new Logger();

        logger.info("Open Steam");
        mainPage = new MainPage();
        logger.info("Choose language");
        mainPage.chooseLanguage(propertiesManager.getProperty(PropertiesManager.configPropertyPath, "language"));
        softAssert.assertEquals(driver.getTitle(), propertiesManager.getProperty(MainPage.currentLanguage, "main_Page_Title"));
        logger.info("Go to the Action page");
        mainPage.menuNavigation(propertiesManager.getProperty(MainPage.currentLanguage, "main_Menu_Item"),
                propertiesManager.getProperty(MainPage.currentLanguage, "main_Menu_SubItem"));

        categoryPage = new CategoryPage();
        softAssert.assertEquals(driver.getTitle(), propertiesManager.getProperty(MainPage.currentLanguage, "category_Page_Title") );
        logger.info("Searching for the game with the maximum discount");
        categoryPage.goToDiscounts();
        categoryPage.searchForBestDiscount();
        logger.info("Opening the Game page");
        categoryPage.gameClick();

        ageCheckPage = new AgeCheckPage();
        if(ageCheckPage.isCheckAgePageOpened()){
            logger.info("Age check");
            ageCheckPage.selectAge(propertiesManager.getProperty(PropertiesManager.configPropertyPath, "year"));
        }

        gamePage = new GamePage();
        logger.info("Go to the Download Steam page");
        gamePage.clickInstallSteam();

        downloadPage = new DownloadPage();
        softAssert.assertEquals(driver.getTitle(), propertiesManager.getProperty(MainPage.currentLanguage,"about_Page_Title"));
        logger.info("Downloading the Steam App");
        downloadPage.downloadApp();
    }
}
