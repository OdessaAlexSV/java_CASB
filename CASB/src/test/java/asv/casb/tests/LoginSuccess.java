package asv.casb.tests;

import org.testng.annotations.Test;

public class LoginSuccess extends TestBase {
    @Test
    public void testOffice365LoginSuccess() {
        app.getOffice365Helper().loginOffice365("admin@saaviknet.com", "Barbapapa1@Offline");
        app.getOffice365Helper().logoutOffice365();
    }
}
