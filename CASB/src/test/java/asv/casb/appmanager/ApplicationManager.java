package asv.casb.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.AssertJUnit.fail;

public class ApplicationManager {
    protected Office365Helper office365Helper;

    protected WebDriver driver;
    protected WebDriverWait wait;
    final StringBuffer verificationErrors = new StringBuffer();
    final Browser browser;

    public ApplicationManager(Browser browser) {
        this.browser = browser;
    }

    public void init() {
       if (browser == Browser.CHROME) {
            System.setProperty("webdriver.chrome.driver", "d:\\Personal\\Tools\\WebDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser == Browser.FIREFOX) {
            System.setProperty("webdriver.gecko.driver","d:\\Personal\\Tools\\WebDrivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser == Browser.EDGE){
            System.setProperty("webdriver.edge.driver", "d:\\Personal\\Tools\\WebDrivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        office365Helper = new Office365Helper(driver,wait);
        System.out.print(" - Started");
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public Office365Helper getOffice365Helper() {
        return office365Helper;
    }
}
