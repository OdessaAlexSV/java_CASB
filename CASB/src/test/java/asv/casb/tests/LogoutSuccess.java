package asv.casb.tests;

import org.testng.annotations.Test;

public class LogoutSuccess extends TestBase {
    @Test
    public void testOffice365LogoutSuccess() throws InterruptedException {
        System.out.print("Step - testOffice365LogoutSuccess");
        app.getOffice365Helper().logoutOffice365();
    }
}
