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

    public void verifyLoginIsSucessFul(){
        Assert.assertTrue(saucePage.isCartIconPresent());
    }

    public  void verifyUserIsLoggedInSuccessfully(){

    }

    public void verifyLoginButtontext(){
        Assert.assertEquals(saucePage.getLoginButtonText(),sauceBaseClass.getConfig().getProperty("buttontext"),"Login Buttton Text being displayed correctly");
    }

    public  void verifySauceLogo(){
        Assert.assertEquals(saucePage.getLogoText(),sauceBaseClass.getConfig().getProperty("logotext"));
    }

    public void verifyIfLocalStorageExist(){
       boolean b= sauceBaseClass.getUtil().isLocalStorageAvailable(sauceBaseClass.getbaseDriver());
       System.out.println(b);
       Assert.assertTrue(b);

    }

    public  void verifyifKeyExistInLocalStorage(String key){
        Assert.assertTrue(sauceBaseClass.getUtil().isLocalStorageKeyExist(sauceBaseClass.getbaseDriver(),key));
    }
    public  void verifyIfKeyhasSomeValue(String key){
        Assert.assertTrue(sauceBaseClass.getUtil().isKeyHasValue(sauceBaseClass.getbaseDriver(),key));
    }

    public void verifyIfKeyHasSomeValueInLocalStorage(String key){
        verifyIfLocalStorageExist();
        verifyifKeyExistInLocalStorage(key);
        verifyifKeyExistInLocalStorage(key);



      String s1=  sauceBaseClass.getUtil().getLocalStorageItem(sauceBaseClass.getbaseDriver(),key);
      System.out.println(s1);
    }


    public  void getCookieValueBykey(String key,String value){
       String s= sauceBaseClass.getUtil().getCookieValue(key,sauceBaseClass.getbaseDriver());
       System.out.println(s);
       Assert.assertEquals(s,value);
    }

    public void verifyLoginFailedMesage(){
        Assert.assertTrue(saucePage.isErrorMessageDisplayed());
        String s = saucePage.getLoginFailedMessage();
        System.out.println(s);
        Assert.assertEquals(s,sauceBaseClass.getConfig().getProperty("loginfailedmessage"),"Login failed message is displayed");
    }

    public void verifyUserisNotLoggedIn(){
        Assert.assertFalse(saucePage.isCartIconPresent());
    }

}
