package asv.casb.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.AssertJUnit.fail;

public class ApplicationManager {
    protected Office365Helper office365Helper;

    protected WebDriver driver;
    protected WebDriverWait wait;
    final StringBuffer verificationErrors = new StringBuffer();

    public void init() {


        System.setProperty("webdriver.chrome.driver", "d:\\Personal\\Tools\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();

      //  System.setProperty("webdriver.gecko.driver","d:\\Personal\\Tools\\WebDrivers\\geckodriver.exe");
      //  driver = new FirefoxDriver();

     //   System.setProperty("webdriver.edge.driver", "d:\\Personal\\Tools\\WebDrivers\\msedgedriver.exe");
     //   WebDriver driver = new EdgeDriver();

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
