package framework.webdriver;

import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    public static WebDriver driver = Browser.driver;

    public BasePage(final By locator, final String pageTitle) {
        String title = pageTitle;
        Label lblPage = new Label(locator, pageTitle);
    }
}
