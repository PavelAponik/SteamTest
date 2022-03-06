package Steam.pages;

import framework.PropertiesManager;
import framework.elements.Label;
import framework.webdriver.BasePage;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.Random;


public class CategoryPage extends BasePage {

    Random random = new Random();
    public static PropertiesManager propertiesManager = new PropertiesManager();
    public static final String DISCOUNT_MENU_LOCATOR = "//div[@class='saleitembrowser_SaleItemBrowserHeader_Eh-ow Panel Focusable']//div[@class='saleitembrowser_FlavorLabel_KDLAS Focusable' and contains(text(),'%s')]";
    public static final String DISCOUNT_LOCATOR = "//div[contains(@class, 'facetedbrowse_FacetedBrowseItems_3EdZT')]//div[contains(@class, 'salepreviewwidgets_StoreSaleDiscountBox_cnkoF')]";
    public static final String GAME_WITH_MAX_DISCOUNT_LOCATOR = "//div[@class='salepreviewwidgets_SaleItemBrowserRow_gASJ2'][%s]//div[contains(@class,'salepreviewwidgets_StoreSaleWidgetTitle_2ekpT')]";
    public static final String GAME_LINK = "//div[@class='salepreviewwidgets_SaleItemBrowserRow_gASJ2'][%s]//div[contains(@class, 'StoreSaleWidgetTitle')]";
    public static String gameName;
    public static Label lblDiscount = new Label(By.xpath(DISCOUNT_LOCATOR));
    public static Label lblGamesList = new Label(By.id("SaleSection_13268"));
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

    public void goToDiscounts(){
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        javascriptExecutor.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
        Label lblDiscountMenu = new Label(By.xpath(String.format(DISCOUNT_MENU_LOCATOR, propertiesManager.getProperty(MainPage.currentLanguage, "discount_tab"))));
        lblDiscountMenu.clickAndWait();
        lblGamesList.scrollToElement();
    }

    public int searchForBestDiscount(){

        int maxSale = 0;
        ArrayList<Integer> myIndList = new ArrayList();
        for (int i = 0; i < lblDiscount.getElementList().size(); i++){
            if(Integer.parseInt(lblDiscount.getElementList().get(i).getText().replace("%", "")) < maxSale){
                maxSale = Integer.parseInt(lblDiscount.getElementList().get(i).getText().replace("%", ""));
            }
        }
        for (int j = 0; j < lblDiscount.getElementList().size(); j++){
            if(Integer.parseInt(lblDiscount.getElementList().get(j).getText().replace("%", "")) == maxSale){
                myIndList.add(j+1);
            }
        }

        int indDiscount = myIndList.get(random.nextInt(myIndList.size()));
        gameName = driver.findElement(By.xpath(String.format(GAME_WITH_MAX_DISCOUNT_LOCATOR, indDiscount))).getText();

        return indDiscount;
    }

    public void gameClick(){
        Label gameSelect = new Label(By.xpath(String.format(GAME_LINK, searchForBestDiscount())));
        gameSelect.click();
        changeTab();
    }
}
