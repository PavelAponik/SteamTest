package steam.pages;

import framework.elements.Button;
import framework.elements.Dropdown;
import framework.elements.Label;
import framework.webdriver.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.HashMap;

public class MainPage extends BasePage {

    public static final String MENU_ITEM_LOCATOR = "//span//a[contains(@class, 'pulldown_desktop') and contains(text(), '%s')]";
    public static final String SUB_MENU_ITEM_LOCATOR = "//div//a[contains(@class, 'popup_menu_item') and contains(text(), '%s')]";
    public static final String LANGUAGE_LIST = "//div[@id='language_dropdown']//a[contains(@class, 'popup_menu_item tight')]";
    HashMap<String, String> languages = new HashMap<>();
    public static String currentLanguage;
    private final Button btnChooseLanguage = new Button(By.id("language_pulldown"), "Choose Language");

    public MainPage() {
        super(By.xpath("//body[@class='v6 infinite_scrolling responsive_page']"), "HomePage");
    }

    public HashMap<String,String> languageList(){
        languages.put("English", "src/test/resources/localization/loc_en.properties");
        languages.put("Русский", "src/test/resources/localization/loc_ru.properties");
        return languages;
    }
    @Step("Choosing the language")
    public void chooseLanguage(String language){
        Dropdown drpChooseLanguage = new Dropdown(By.xpath(String.format(SUB_MENU_ITEM_LOCATOR, language)), language);
        btnChooseLanguage.click();
        if(!isLanguageChosen(language)){
            currentLanguage = languageList().get(language);
            drpChooseLanguage.click();
        }else{
            currentLanguage = languageList().get(language);
            btnChooseLanguage.click();
        }
    }

    @Step("Language is chosen")
    public boolean isLanguageChosen(String language){
        Dropdown drpLanguageList = new Dropdown(By.xpath(LANGUAGE_LIST), "languages");
        for (WebElement element : drpLanguageList.getElementList()){
            if (element.getText().startsWith(language)){
                return false;
            }
        }
        return true;
    }

    @Step("Going to the Action Page")
    public void menuNavigation(String menuItem, String subMenuItem){
        Label lblMenuItem = new Label(By.xpath(String.format(MENU_ITEM_LOCATOR, menuItem)), menuItem);
        Label lblSubMenuItem = new Label(By.xpath(String.format(SUB_MENU_ITEM_LOCATOR, subMenuItem)), subMenuItem);
        lblMenuItem.moveToElement();
        lblSubMenuItem.click();
    }

}
