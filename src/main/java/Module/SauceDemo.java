package Module;

import Base.SauceBaseClass;
import PageObjects.SaucePage;
import org.testng.Assert;

import java.util.List;

public class SauceDemo {

    private SaucePage saucePage= null;
    private  SauceBaseClass sauceBaseClass= null;

    public SauceDemo(SauceBaseClass baseClass){
        this.saucePage=new SaucePage(baseClass);
        this.sauceBaseClass=baseClass;
    }


    public void login(String username,String password){
        saucePage.enterUserName(username);
        saucePage.enterPassword(password);
        saucePage.clickLoginButton();
    }


    public  void verifyUserIsLoggedInSuccessfully(){

    }

    public void verifyLoginButtontext(){
        Assert.assertEquals(saucePage.getLoginButtonText(),sauceBaseClass.getConfig().getProperty("buttontext"),"Login Buttton Text being displayed correctly");
    }

    public  void verifySauceLogo(){
        Assert.assertEquals(saucePage.getLogoText(),sauceBaseClass.getConfig().getProperty("logotext"));
    }
}
