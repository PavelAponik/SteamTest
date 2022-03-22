package steam.pages;

import framework.PropertiesManager;
import framework.elements.Button;
import framework.webdriver.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;

public class DownloadPage extends BasePage{

    PropertiesManager propertiesManager = new PropertiesManager();

    public static final String INSTALL_STEAM_APP = "//a[contains(@class, 'about_install')]";
    Button btnInstallSteamApp = new Button(By.xpath(INSTALL_STEAM_APP));

    File file = new File(System.getProperty("user.dir")
            + propertiesManager.getProperty(PropertiesManager.configPropertyPath, "download_directory")
            + propertiesManager.getProperty(PropertiesManager.configPropertyPath, "download_file_name"));

    public boolean waitForDownload(final File file){
        return (new WebDriverWait(driver,
                Integer.parseInt(propertiesManager.getProperty(PropertiesManager.configPropertyPath, "implicit_wait"))).until((ExpectedCondition<Boolean>) driver -> file.canRead()));
    }

    public void downloadApp(){
        btnInstallSteamApp.click();
        this.waitForDownload(file);
    }

    public boolean isFilePresent(){
        return file.exists();
    }

    public void deleteFile(boolean bool){
        if(bool){
            file.delete();
        }
    }
}
