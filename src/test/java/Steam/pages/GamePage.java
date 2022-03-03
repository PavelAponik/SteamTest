package Steam.pages;

import framework.elements.Button;
import framework.webdriver.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GamePage extends BasePage {

    public static final String installSteam = "//div[contains(@class, 'header_installsteam_btn header_installsteam_btn_green')]";
    Button btnInstallSteam = new Button(By.xpath(installSteam));

    public GamePage(WebDriver driver) {
        super(driver);
    }

    public void clickIstallSteam(){
        btnInstallSteam.click();
    }
}
