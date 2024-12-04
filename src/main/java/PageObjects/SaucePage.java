package PageObjects;

import Base.SauceBaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AbstractAnnotations;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.time.Duration;
import java.util.List;

public class SaucePage  extends BasePage {


    private static WebDriver driver;
private    SauceBaseClass baseClass=null;


By loginbutton = By.id("login-button");
By usernametextbox=By.id("user-name");
By passwordtextbox=By.id("password");
By usernamelist=By.xpath("//div[@id='login_credentials']/br/preceding-sibling::text()");
By password=By.xpath("//div[@class='login_password']/h4");
By logotext= By.className("login_logo");




    public SaucePage( SauceBaseClass baseClass) {
       super(baseClass);

        this.baseClass=baseClass;

    }


    public String getLoginButtonText(){
        return getTextsafely(getElementsafely(loginbutton));
    }

    public String getLogoText(){
        return getTextsafely(getElementsafely(logotext));
    }
    public void enterUserName(String name){
      sendKeysSafely(usernametextbox,name);
    }

    public void enterPassword(String password){
        sendKeysSafely(passwordtextbox,password);
    }

    public  void clickLoginButton(){
        clickElementSafely(loginbutton);
    }

    public List<WebElement> getAllUserNames(){
        return driver.findElements(usernamelist);
    }
    public void getValidPassword(){
        getTextsafely(getElementsafely(passwordtextbox));
    }

    public List<String> getStringUsernames(){
        return  getStringListFromElementList(getAllUserNames());
    }

}
