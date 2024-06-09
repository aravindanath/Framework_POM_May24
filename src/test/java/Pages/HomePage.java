package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    
    @FindBy(xpath = "//span[text()='My Account']")
    public WebElement myAccountMenu;

    @FindBy(xpath = "//a[text()='Register']")
    public WebElement regiserMenu;





    // bussiness login


    public void navigateToRegister() {
        myAccountMenu.click();
        regiserMenu.click();
    }


}
