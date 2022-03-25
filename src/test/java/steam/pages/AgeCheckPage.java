package steam.pages;

import framework.elements.Button;
import framework.elements.Dropdown;
import framework.elements.TextBox;
import framework.webdriver.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class AgeCheckPage extends BasePage {

    private final TextBox txbCheckAge = new TextBox(By.xpath("//div[contains(@class, 'agegate_birthday_desc')]"), "Check Age");
    private final Dropdown drpAgeYear = new Dropdown(By.id("ageYear"), "Year");
    private final Button btnViewPage = new Button(By.id("view_product_page_btn"), "View Page");

    public AgeCheckPage() {
        super(By.xpath("//body[@class='v6 infinite_scrolling responsive_page']"), "AgeCheckPage");
    }

    public boolean isCheckAgePageOpened(){
        try {
            return txbCheckAge.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    @Step("Age Check")
    public void selectAge(String year){
        drpAgeYear.select(year);
        btnViewPage.click();
    }
}
