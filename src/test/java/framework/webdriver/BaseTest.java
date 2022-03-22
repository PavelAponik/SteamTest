package framework.webdriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest extends Browser{
    protected static Logger logger;

    @BeforeTest
    public void before(){
        setUp();
    }

    @AfterTest
    public void after(){
        tearDown();
    }
}
