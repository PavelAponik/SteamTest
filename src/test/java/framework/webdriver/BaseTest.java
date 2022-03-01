package framework.webdriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;




public abstract class BaseTest extends Browser {


    @BeforeClass
    public void before(){
        Browser.setUp();
    }

    @AfterClass
    public void after(){
        //Browser.tearDown();
    }

}
