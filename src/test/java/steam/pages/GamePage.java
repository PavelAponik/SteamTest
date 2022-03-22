package steam.pages;

import framework.elements.Button;
import framework.webdriver.BasePage;
import org.openqa.selenium.By;

public class GamePage extends BasePage {

    private final Button btnInstallSteam = new Button(By.xpath("//div[contains(@class, 'header_installsteam_btn header_installsteam_btn_green')]"), "Install Steam");

    public GamePage() {
        super(By.xpath("//div[@id = 'appHubAppName'"),"GamePage");
    }

    public void clickInstallSteam(){
        btnInstallSteam.click();
    }
}
