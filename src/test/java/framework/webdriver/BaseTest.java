package framework.webdriver;

import Steam.pages.AboutPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public abstract class BaseTest extends Browser {

    protected static Logger logger;

    @BeforeTest
    public void before(){
        Browser.setUp();
    }

    @BeforeTest
    public void trashClean(){
        AboutPage aboutPage = new AboutPage();
        aboutPage.deleteFile(aboutPage.isFilePresent());
    }

    @AfterTest
    public void after(){
        Browser.tearDown();
    }

}
