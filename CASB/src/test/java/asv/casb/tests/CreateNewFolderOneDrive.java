package asv.casb.tests;

import org.testng.annotations.Test;

public class CreateNewFolderOneDrive extends TestBase{
    @Test
    public void testCreateNewFolderOneDrive() throws InterruptedException {
        app.getOffice365Helper().loginOffice365("admin@saaviknet.com", "Barbapapa1@Offline");
        app.getOffice365Helper().openLaunchAppOffice365();
        app.getOffice365Helper().getOneDriveHelper().openOneDrive();
        app.getOffice365Helper().getOneDriveHelper().createFolderOneDrive("TempAutoTestFolder");
        app.getOffice365Helper().logoutOffice365();
    }
}
