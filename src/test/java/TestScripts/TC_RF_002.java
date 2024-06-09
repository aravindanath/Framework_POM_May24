package TestScripts;

import Pages.BasePage;
import Pages.HomePage;
import Pages.RegisterPage;
import org.testng.annotations.Test;

public class TC_RF_002 extends BaseTest {

    /**
     * Validate Registering an Account by entering different passwords
     * into 'Password' and 'Password Confirm' fields
     */

    @Test
    public void TC_RF_002() {

        String fn = BasePage.firstName(), ln = BasePage.lastName(),
                email = BasePage.emailid(), password = BasePage.password(),mobile = BasePage.mobileNumber();


        HomePage hp = new HomePage(driver);
        hp.navigateToRegister();
        RegisterPage rp = new RegisterPage(driver);
        rp.registerAccount(fn, ln, email,mobile, password,"password");
        rp.assertInvalidPasswordMsg();
    }
}
