package Steam.pages;

import framework.elements.Button;
import framework.elements.Dropdown;
import framework.elements.TextBox;
import framework.webdriver.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class AgeCheckPage extends BasePage {

    public AgeCheckPage(WebDriver driver) {
        super(driver);
    }

    TextBox tbxCheckAge = new TextBox(By.xpath("//div[contains(@class, 'agegate_birthday_desc')]"));
    Dropdown drpAgeYear = new Dropdown(By.id("ageYear"));
    Button btnViewPage = new Button(By.id("view_product_page_btn"));

    public boolean isCheckAgePageOpened(){
        try {
            return tbxCheckAge.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public void selectAge(String year){
        drpAgeYear.select(year);
        btnViewPage.click();
    }
}
