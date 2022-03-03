package Steam.pages;

import framework.PropertiesManager;
import framework.webdriver.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class CategoryPage extends BasePage {

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public static JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
    public static PropertiesManager propertiesManager = new PropertiesManager();
    public WebDriverWait wait = new WebDriverWait(driver, 10);
    public Actions actions = new Actions(driver);
    public static final String discountMenuLocator = "//div[contains(@class, 'saleitembrowser_FlavorLabel_KDLAS Focusable') and contains(text(), '%s')]";
    public static final String discountLocator = "//div[contains(@class, 'facetedbrowse_FacetedBrowseItems_3EdZT')]//div[contains(@class, 'salepreviewwidgets_StoreSaleDiscountBox_cnkoF')]";
    public static final String maxDiscountLocator = "//div[contains(@class, 'facetedbrowse_FacetedBrowseItems_3EdZT')]//div[contains(@class, 'salepreviewwidgets_StoreSaleDiscountBox_cnkoF') and contains(text(), '%s')]";
    public static final String gameWithMaxDiscountLocator = "//div[contains(@class, 'facetedbrowse_FacetedBrowseItems_3EdZT')]//div[contains(@class, 'salepreviewwidgets_StoreSaleDiscountBox_cnkoF') and contains(text(), '%s')]/..//..//..//..//div[contains(@class,'salepreviewwidgets_StoreSaleWidgetTitle_2ekpT')]";


    public void goToDiscounts(){
        WebElement lblDiscountMenu = driver.findElement(By.xpath(String.format(discountMenuLocator, propertiesManager.getProperty(MainPage.currentLanguage, "discount_tab"))));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", lblDiscountMenu);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(discountMenuLocator)));
        javascriptExecutor.executeScript("arguments[0].click()", lblDiscountMenu);
    }
    public void searchForBestDiscount(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(discountLocator)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(discountLocator))));

        List<WebElement> discounts = driver.findElements(By.xpath(discountLocator));
        List<String> discountValue = new ArrayList<>();

        for (WebElement discount : discounts) {
            discount.getText();
            discountValue.add(discount.getText());
        }

        String maxDiscount = Collections.max(discountValue);
        List<WebElement> maxDiscounts = driver.findElements(By.xpath(String.format(maxDiscountLocator, maxDiscount)));
        Random random = new Random();
        int randomMax = random.nextInt(maxDiscounts.size());
        System.out.println(maxDiscount);
        String randomDiscount = maxDiscounts.get(randomMax).getText();
        driver.findElement(By.xpath(String.format(gameWithMaxDiscountLocator, randomDiscount))).click();
    }

}
