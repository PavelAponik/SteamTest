package Steam.pages;

import framework.elements.Button;
import framework.webdriver.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GamePage extends BasePage {

    public WebDriverWait wait = new WebDriverWait(driver, 10);
    public static final String installSteam = "//a[contains(@class, 'header_installsteam_btn_content')]";
    Button btnInstallSteam = new Button(By.xpath(installSteam));

    public GamePage(WebDriver driver) {
        super(driver);
    }

    public void clickIstallSteam(){
        btnInstallSteam.click();
    }
}
