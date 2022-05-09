package asv.casb.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse {public static void main(String[] args) {
    WebDriver driver;
    System.setProperty("webdriver.chrome.driver","d:\\Personal\\Tools\\ChromeDriver\\chromedriver.exe");
    driver= new ChromeDriver();
    try {
        // Navigate to Url
        driver.get("https://google.com");

        // Store 'Gmail' anchor web element
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        // Capture x and y offset positions of element
        int xOffset = gmailLink.getRect().getX();
        int yOffset = gmailLink.getRect().getY();
        Actions actionProvider = new Actions(driver);
        // Performs mouse move action onto the offset position
        actionProvider.moveByOffset(xOffset, yOffset).click().build().perform();
    } finally {
        driver.quit();
    }
}
}
