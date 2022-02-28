package Steam.pages;

import framework.webdriver.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CategoryPage extends BasePage {

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public static final String discountLocator = "//div[@id='specials_container']//div[contains(@class, 'discount_block')]/div[contains(@class, 'discount_pct')]";
    public static final String maxDiscountLocator = "//div[@id='specials_container']//div[contains(@class, 'discount_block')]/div[contains(@class, 'discount_pct') and contains(text(), '%s')]";

    public void searchForBestDiscount(){
        List<WebElement> discounts = driver.findElements(By.xpath(discountLocator));
        List<String> discountValue = new ArrayList<>();
        for (WebElement discount : discounts){
            discount.getText();
            discountValue.add(discount.getText());
        }
        String maxDiscount = Collections.max(discountValue);
        List<WebElement> maxDiscounts = driver.findElements(By.xpath(String.format(maxDiscountLocator, maxDiscount)));
        Random random = new Random();
        int randomMax = random.nextInt(maxDiscounts.size());
        maxDiscounts.get(randomMax).click();
    }

}
