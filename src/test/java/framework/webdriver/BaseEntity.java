package framework.webdriver;


import framework.PropertiesResourceManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public abstract class BaseEntity {

    protected static Browser browser = Browser.getInstance();
    protected ITestContext context;

    @BeforeClass
    public void before(ITestContext context){
        this.context = context;
        browser = Browser.getInstance();
        browser.windowMaximaze();

    }

    @AfterClass
    public void after(){
        if(browser.isBrowserAlive()){
            browser.exit();

        }
    }

}
