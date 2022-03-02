package framework.elements;

import framework.PropertiesManager;
import framework.webdriver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseElement {

    WebDriver driver = Browser.driver;
    WebElement element;
    By locator;
    WebDriverWait wait = new WebDriverWait(driver, 10);
    List<WebElement> elementList;
    PropertiesManager propertiesManager = new PropertiesManager();


    public BaseElement(By locator){
        this.locator = locator;
    }

    public WebElement getElement(){
        waitUntilPresent();
        return element;
    }

    public List<WebElement> getElementList(){
        waitUntilPresent();
        elementList = driver.findElements(locator);
        return elementList;
    }

    public boolean isPresent() {
        try {
            element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isDisplayed(){
        return driver.findElement(locator).isDisplayed();
    }

    public boolean waitUntilPresent() {
        wait.until((ExpectedCondition<Boolean>) (driver) -> {
            try {
                return isPresent();
            }catch (Exception e){
                return false;
            }
        });
        try {
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(propertiesManager.getProperty(PropertiesManager.configPropertyPath, "implicit_wait")), TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void moveToElement(){
        Actions actions = new Actions(driver);
        waitUntilPresent();
        actions.moveToElement(getElement()).build().perform();
    }

    public void click(){
        waitUntilPresent();
        element.click();
    }
}
