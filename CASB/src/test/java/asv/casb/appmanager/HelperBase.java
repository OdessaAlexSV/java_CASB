package asv.casb.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    WebDriver driver;
    WebDriverWait wait;

    public HelperBase(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    protected void waitAndTypeById(String locator, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
        driver.findElement(By.id(locator)).clear();
        driver.findElement(By.id(locator)).sendKeys(text);
    }

    protected void waitAndTypeByPath(String locator, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        driver.findElement(By.xpath(locator)).clear();
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }

    protected void waitAndClickByXpath(String locator) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        driver.findElement(By.xpath(locator)).click();
    }

    protected void waitAndClickById(String locator) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
        driver.findElement(By.id(locator)).click();
    }
}
