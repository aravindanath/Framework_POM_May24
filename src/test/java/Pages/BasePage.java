package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BasePage {

    protected WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public static String getValue(String key) {
        String path = System.getProperty("user.dir")+ File.separator+"config.properties";
        String value = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            Properties properties = new Properties();
            properties.load(fis);
            value = properties.getProperty(key);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }


    public static String firstName(){
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String lastName(){
        Faker faker = new Faker();
        return faker.name().lastName();
    }


    public static String emailid(){
        Faker faker = new Faker();
        return faker.name().firstName()+"@testnail.com";
    }

    public static String mobileNumber(){
        Faker faker = new Faker();
        return faker.number().digits(10);
    }


    public static void waitForElement(long timeout){
        try{
            Thread.sleep(timeout);
        }catch (InterruptedException e){

        }
    }

    public static void verifyTitle(WebElement element, String text){
        String actual =  element.getText();
        Assert.assertEquals(actual, text);
    }


    public static void verifyElementIsEnable(WebElement element){
        Assert.assertTrue(element.isEnabled());
    }

    public static void verifyElementIsSelected(WebElement element){
        Assert.assertTrue(element.isSelected());
    }

    public static String password(){
        return "password@123";
    }

}
