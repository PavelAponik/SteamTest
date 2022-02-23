package Steam.pages;

import framework.webdriver.BaseEntity;
import org.openqa.selenium.WebDriver;

public class CategoryPage extends BaseEntity {
    public static final String discount = "//div[@id='specials_container']//div[contains(@class, 'discount_block')]/div[contains(@class, 'discount_pct')]";

    public CategoryPage(WebDriver driver) {
        super(driver);
    }
}
