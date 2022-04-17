package asv.casb.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScrollByVisibleElement {

    WebDriver driver;
    @Test
    public void ByVisibleElement() {
        System.setProperty("webdriver.chrome.driver", "d:\\Personal\\Tools\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Launch the application
        driver.get("https://www.browserstack.com/guide/selenium-scroll-tutorial");

        //Locating element by link text and store in variable "Element"
        WebElement Element = driver.findElement(By.linkText("Try Selenium Testing For Free"));

        // Scrolling down the page till the element is found
        js.executeScript("arguments[0].scrollIntoView(true);", Element);
        Element.click();
    }
}
