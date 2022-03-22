package framework.webdriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest{
    protected static Logger logger;

    @BeforeTest
    public void before(){
        Browser.setUp();
    }

    @AfterTest
    public void after(){
        Browser.tearDown();
    }
}
