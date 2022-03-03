package framework.webdriver;

import framework.PropertiesManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;


public abstract class BaseTest extends Browser {


    @BeforeClass
    public void before(){
        Browser.setUp();
        File file = new File(propertyManager.getProperty(PropertiesManager.configPropertyPath, "src/downloads/") +
                propertyManager.getProperty(PropertiesManager.configPropertyPath, "SteamSetup.exe"));
        if (file.exists()){
            file.delete();
        }
    }

    @AfterClass
    public void after(){
        //Browser.tearDown();
    }

}
