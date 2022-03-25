package steam.pages;

import framework.elements.Button;
import framework.webdriver.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class GamePage extends BasePage {

    private final Button btnInstallSteam = new Button(By.xpath("//div[contains(@class, 'header_installsteam_btn header_installsteam_btn_green')]"), "Install Steam");

    public GamePage() {
        super(By.xpath("//div[@id = 'appHubAppName'"),"GamePage");
    }

    @Step("Go to Install Steam")
    public void clickInstallSteam(){
        btnInstallSteam.click();
    }
}
