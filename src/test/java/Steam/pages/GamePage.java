package Steam.pages;

import framework.elements.Button;
import framework.webdriver.BasePage;
import org.openqa.selenium.By;

public class GamePage extends BasePage {

    public static final String INSTALL_STEAM = "//div[contains(@class, 'header_installsteam_btn header_installsteam_btn_green')]";
    Button btnInstallSteam = new Button(By.xpath("//div[contains(@class, 'header_installsteam_btn header_installsteam_btn_green')]"));

    public void clickInstallSteam(){
        btnInstallSteam.click();
    }
}
