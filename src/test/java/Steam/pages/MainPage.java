package Steam.pages;

import framework.webdriver.BaseEntity;
import org.openqa.selenium.WebDriver;

public class MainPage extends BaseEntity {
    public static final String category = "//span//a[contains(@class, 'pulldown_desktop')]";
    public static final String dropdownItem = "//div//a[contains(@class, 'popup_menu_item') and contains(text(), 'Action')]";
    public static final String LanguageDropdownItem = "//div//a[contains(@class, 'popup_menu_item') and contains(text(), 'Русский')]";

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
