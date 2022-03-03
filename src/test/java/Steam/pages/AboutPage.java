package Steam.pages;

import framework.elements.Button;
import framework.webdriver.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class AboutPage extends BasePage{

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    //File file = new File();

    public static final String installSteamApp = "//a[contains(@class, 'about_install')]";
    Button btnInstallSteamApp = new Button(By.xpath(installSteamApp));

    public void downloadApp(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(installSteamApp)));
        btnInstallSteamApp.click();






    }
}
