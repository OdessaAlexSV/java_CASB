package asv.casb.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class OneDriveHelper extends HelperBase {

    public OneDriveHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void createFolderOneDrive(String nameFolder) {
        waitAndClickByXpath("//button[@title='Create a new folder or document in this location']");
        waitAndClickByXpath("//button[@name='Folder']");
        waitAndTypeByPath("//input[@placeholder='Enter your folder name']",nameFolder);
        waitAndClickById("id__270");
    }

    public void openOneDrive() {
        waitAndClickByXpath("//span[normalize-space()='All apps']");
        waitAndClickByXpath("//span[contains(text(),'OneDrive')]");

        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
    }

    public void uploadFilesOneDrive(String filePath) throws Exception {
        waitAndClickByXpath("//button[@title='Upload files from your computer to this location']");
        waitAndClickByXpath("//span[normalize-space()='Files']");

        File file = new File(filePath);
        StringSelection s = new StringSelection(file.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
    }

    public void openFolderOneDrive(String nameFolder) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title=" + nameFolder + "]")));
        driver.findElement(By.cssSelector("button[title=" + nameFolder + "]")).click();
    }

    public void deleteFolderOneDrive(String folderName) throws InterruptedException, AWTException {
        By mySelector = By.xpath("(//span[@class='signalFieldValue_81537cac'])");
        List<WebElement> allElements = driver.findElements(mySelector);

        System.out.println();
        int positionFolder = 0;
        for (int i = 0; i <= allElements.size(); i++) {
            String title = allElements.get(i).findElement(By.xpath("(//span[@class='signalFieldValue_81537cac'])[" + (i + 1) + "]//button")).getAccessibleName();
            System.out.println(title + " - " + (i + 1));
            if (title.equals(folderName)) {
                positionFolder = i + 1;
                i = allElements.size();
            }
        }

        WebElement element = driver.findElement(By.xpath("(//span[@class='signalFieldValue_81537cac'])[" + positionFolder + "]//button[@title='" + folderName + "']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        Thread.sleep(1000);

        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
        waitAndClickByXpath("//span[normalize-space()='Delete']");
        deleteFolderOneDrivePopupConfirm();
    }

    public void deleteFolderOneDrivePopupConfirm() throws AWTException, InterruptedException {
        Thread.sleep(500);

        Robot robot = new Robot();
        for (int k = 0; k < 2; k++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(500);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
