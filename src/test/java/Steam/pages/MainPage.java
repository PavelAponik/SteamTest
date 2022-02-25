package Steam.pages;

import framework.elements.Button;
import framework.elements.Dropdown;
import framework.elements.Label;
import framework.webdriver.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }


    Button btnChooseLanguage = new Button(By.id("language_pulldown"));
    String menuItemLocator = "//span//a[contains(@class, 'pulldown_desktop') and contains(text(), '%s')]";
    String subMenuItemLocator = "//div//a[contains(@class, 'popup_menu_item') and contains(text(), '%s')]";
    String languageList = "//div[@id='language_dropdown']//a[contains(@class, 'popup_menu_item tight')]";

    public void chooseLanguage(String language){
        Dropdown drpChooseLanguage = new Dropdown(By.xpath(String.format(subMenuItemLocator, language)));
        btnChooseLanguage.click();
        if(isLanguageChosen(language)==false){
            drpChooseLanguage.click();
        }
    }

    public boolean isLanguageChosen(String language){
        Dropdown drpLanguageList = new Dropdown(By.xpath(languageList));
        for (WebElement element : drpLanguageList.getElementList()){
            if (element.getText().startsWith(language)){
                return false;
            }
        }
        return true;
    }


    public void menuNavigation(String menuItem, String subMenuItem){
        Label lblMenuItem = new Label(By.xpath(String.format(menuItemLocator, menuItem)));
        Label lblSubMenuItem = new Label(By.xpath(String.format(subMenuItemLocator, subMenuItem)));
        lblMenuItem.moveToElement();
        lblSubMenuItem.click();
    }

}
