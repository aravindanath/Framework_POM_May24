package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    public WebElement firstNameTextField;

    @FindBy(id = "input-lastname")
    public WebElement lastNameTextField;

    @FindBy(id = "input-email")
    public WebElement emailTextField;

    @FindBy(id = "input-telephone")
    public WebElement telephoneTextField;

    @FindBy(id = "input-password")
    public WebElement passwordTextField;

    @FindBy(id = "input-confirm")
    public WebElement confirmPasswordTextField;

    @FindBy(xpath = "//input[@name='agree']")
    public WebElement agreeCheckBox;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    public WebElement titleMsg;

    @FindBy(xpath = "//*[text()='Password confirmation does not match password!']")
    public WebElement incorrectPasswordTextField;


    public void registerAccount(String firstName, String lastName,
                                String email,String telephone,
                                String password, String confirmPassword){

        firstNameTextField.sendKeys(firstName);
        lastNameTextField.sendKeys(lastName);
        emailTextField.sendKeys(email);
        telephoneTextField.sendKeys(telephone);
        passwordTextField.sendKeys(password);
        confirmPasswordTextField.sendKeys(confirmPassword);
        agreeCheckBox.click();
        continueButton.click();
    }


    public void assertMessage(){
        BasePage.verifyTitle(titleMsg,"Your Account Has Been Created!");
    }

    public void assertInvalidPasswordMsg(){
        BasePage.verifyTitle(incorrectPasswordTextField,"Password confirmation does not match password!");
    }


}
