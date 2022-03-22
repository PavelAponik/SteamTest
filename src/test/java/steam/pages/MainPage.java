package steam.pages;

import framework.elements.Button;
import framework.elements.Dropdown;
import framework.elements.Label;
import framework.webdriver.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.HashMap;

public class MainPage extends BasePage {

    public static final String MENU_ITEM_LOCATOR = "//span//a[contains(@class, 'pulldown_desktop') and contains(text(), '%s')]";
    public static final String SUB_MENU_ITEM_LOCATOR = "//div//a[contains(@class, 'popup_menu_item') and contains(text(), '%s')]";
    public static final String LANGUAGE_LIST = "//div[@id='language_dropdown']//a[contains(@class, 'popup_menu_item tight')]";
    HashMap<String, String> languages = new HashMap<>();
    public static String currentLanguage;
    Button btnChooseLanguage = new Button(By.id("language_pulldown"));

    public HashMap<String,String> languageList(){
        languages.put("English", "src/test/resources/localization/loc_en.properties");
        languages.put("Русский", "src/test/resources/localization/loc_ru.properties");
        return languages;
    }

    public void chooseLanguage(String language){
        Dropdown drpChooseLanguage = new Dropdown(By.xpath(String.format(SUB_MENU_ITEM_LOCATOR, language)));
        btnChooseLanguage.click();
        if(!isLanguageChosen(language)){
            currentLanguage = languageList().get(language);
            drpChooseLanguage.click();
        }else{
            currentLanguage = languageList().get(language);
            btnChooseLanguage.click();
        }
    }

    public boolean isLanguageChosen(String language){
        Dropdown drpLanguageList = new Dropdown(By.xpath(LANGUAGE_LIST));
        for (WebElement element : drpLanguageList.getElementList()){
            if (element.getText().startsWith(language)){
                return false;
            }
        }
        return true;
    }

    public void menuNavigation(String menuItem, String subMenuItem){
        Label lblMenuItem = new Label(By.xpath(String.format(MENU_ITEM_LOCATOR, menuItem)));
        Label lblSubMenuItem = new Label(By.xpath(String.format(SUB_MENU_ITEM_LOCATOR, subMenuItem)));
        lblMenuItem.moveToElement();
        lblSubMenuItem.click();
    }

}
