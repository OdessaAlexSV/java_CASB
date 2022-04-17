package asv.casb.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Office365Helper extends HelperBase {

    private final OneDriveHelper oneDriveHelper;

    public Office365Helper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        oneDriveHelper = new OneDriveHelper(driver, wait);
    }

    public void loginOffice365(String userName, String userPassword) {
        String baseUrl = "https://login.microsoftonline.com";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        if (!driver.findElements(By.id("otherTileText")).isEmpty()) {
            waitAndClickById("otherTileText");
        }
            waitAndTypeById("i0116", userName);
            waitAndClickById("idSIButton9");

            waitAndTypeById("i0118", userPassword);
            waitAndClickById("idSIButton9");

            waitAndClickById("idSIButton9");
    }

    public void logoutOffice365() throws InterruptedException {
        waitAndClickByXpath("//button[@id='O365_MainLink_Me']");
        waitAndClickByXpath("//a[@id='mectrl_body_signOut']");
        waitAndClickByXpath("//img[@role='presentation']");
    }

    public void openLaunchAppOffice365() throws InterruptedException {
        waitAndClickByXpath("//button[@id='O365_MainLink_NavMenu']");
    }

    public OneDriveHelper getOneDriveHelper() {
        return oneDriveHelper;
    }
}



