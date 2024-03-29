package steam.pages;

import framework.webdriver.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CategoryPage extends BasePage {

    public static final String DISCOUNT_LOCATOR = "//div[contains(@class, 'discount_block  discount_block_inline')]/div[contains(@class, 'discount_pct')]";
    public static final String GAME_WITH_MAX_DISCOUNT_LOCATOR = "//div[contains(@class, 'discount_block  discount_block_inline')]/div[@class = 'discount_pct' and contains(text(), '%s')]";

    public CategoryPage() {
        super(By.xpath("//body[@class='v6 infinite_scrolling responsive_page']"), "CategoryPage");
    }

    @Step("Searching for the game with highest discount")
    public void searchForBestDiscount(){
        List<WebElement> discounts = driver.findElements(By.xpath(DISCOUNT_LOCATOR));
        List<String> list = new ArrayList<>();
        for (WebElement discount : discounts) {
            list.add(discount.getText());
        }
        String maxDiscount = Collections.max(list);
        List<WebElement> gamesWithMaxDiscount = driver.findElements(By.xpath(String.format(GAME_WITH_MAX_DISCOUNT_LOCATOR, maxDiscount)));
        Random r = new Random();
        int randomValue = r.nextInt(gamesWithMaxDiscount.size());
        gamesWithMaxDiscount.get(randomValue).click();
    }
}
