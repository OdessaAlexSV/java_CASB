package asv.casb.tests;

import org.testng.annotations.Test;

import java.awt.*;

public class DeleteFolder extends TestBase {
    @Test
    public void testDeleteFolderOneDrive() throws InterruptedException, AWTException {
        app.getOffice365Helper().loginOffice365("admin@saaviknet.com", "Barbapapa1@Offline");
        app.getOffice365Helper().openLaunchAppOffice365();
        app.getOffice365Helper().getOneDriveHelper().openOneDrive();
        app.getOffice365Helper().getOneDriveHelper().deleteFolderOneDrive("TempAutoTestFolder");
        app.getOffice365Helper().logoutOffice365();
    }
}
