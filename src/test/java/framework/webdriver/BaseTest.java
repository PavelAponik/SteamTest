package framework.webdriver;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import javax.naming.NamingException;

public abstract class BaseTest extends Browser {


    @BeforeClass
    public void before() throws NamingException {
        Browser.setUp();


    }

    @AfterClass
    public void after(){
        Browser.tearDown();
    }

}
