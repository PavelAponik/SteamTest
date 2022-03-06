package Steam.pages;

import framework.elements.Button;
import framework.webdriver.BasePage;
import org.openqa.selenium.By;

public class GamePage extends BasePage {

    Button btnInstallSteam = new Button(By.xpath("//div[contains(@class, 'header_installsteam_btn header_installsteam_btn_green')]"));

    public void clickInstallSteam(){
        btnInstallSteam.click();
    }
}
