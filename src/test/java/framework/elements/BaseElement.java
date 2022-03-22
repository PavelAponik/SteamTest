package framework.elements;

import framework.PropertiesManager;
import framework.webdriver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseElement {

    WebDriver driver = Browser.driver;
    WebElement element;
    By locator;
    String name;
    WebDriverWait wait = new WebDriverWait(driver, 10);
    List<WebElement> elementList;
    PropertiesManager propertiesManager = new PropertiesManager();
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

    public BaseElement(By locator, String name){
        this.locator = locator;
        this.name = name;
    }

    public WebElement getElement(){
        waitUntilPresent();
        return element;
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
        wait.until((ExpectedCondition<Boolean>) (x) -> {
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

    public void clickAndWait(){
        click();
        waitForPageToLoad();
    }

    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(propertiesManager.getProperty(PropertiesManager.configPropertyPath, "implicit_wait"))));
        try {
            wait.until((ExpectedCondition<Boolean>) d -> {
                if (!(d instanceof JavascriptExecutor)) {
                    return true;
                }
                Object result = ((JavascriptExecutor) d)
                        .executeScript("return document['readyState'] ? 'complete' == document.readyState : true");
                return result instanceof Boolean && (Boolean) result;
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<WebElement> getElementList(){
        if (arePresent()) return elementList;
        else return null;
    }

    private boolean arePresent() {
        try {
            wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
                public Boolean apply(final WebDriver driver) {
                    try {
                        elementList = driver.findElements(locator);
                        for (WebElement el : elementList) {
                            if (el != null && el.isDisplayed()) {
                                element = el;
                                return element.isDisplayed();
                            }
                        }
                        element = driver.findElement(locator);
                    } catch (Exception e) {
                        return false;
                    }
                    return element.isDisplayed();
                }
            });
        } catch (Exception e) {
            return false;
        }
        try {
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(propertiesManager.getProperty(PropertiesManager.configPropertyPath, "implicit_wait")), TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void scrollToElement() {
        waitUntilPresent();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

}
