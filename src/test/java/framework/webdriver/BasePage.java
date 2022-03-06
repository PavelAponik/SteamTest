package framework.webdriver;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    public static WebDriver driver = Browser.driver;

    public void changeTab(){
        for (String windowHandle : driver.getWindowHandles()) {
            if(!driver.getWindowHandle().contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
