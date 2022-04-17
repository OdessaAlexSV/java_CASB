package asv.casb.tests;

import org.testng.annotations.Test;

public class UploadFile_FromUpperMenu extends TestBase {
    @Test
    public void testUploadFileFromUpperMenu() throws Exception {
        System.out.print("Step - testUploadFileFromUpperMenu");
        app.getOffice365Helper().loginOffice365("admin@saaviknet.com", "Barbapapa1@Offline");
        app.getOffice365Helper().openLaunchAppOffice365();
        app.getOffice365Helper().getOneDriveHelper().openOneDrive();
        app.getOffice365Helper().getOneDriveHelper().uploadFilesOneDrive("uploadFiles/Test001.docx");
    }
}
	
