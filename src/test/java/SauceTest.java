import Base.SauceBaseClass;
import PageObjects.SaucePage;
import Module.SauceDemo;
import org.testng.annotations.*;
import DataProvider.SauceData;

public class SauceTest extends SauceBaseClass {



private  SaucePage sp=new SaucePage(this);
SauceDemo demo=null;

    @BeforeMethod
    public void initializesClasses(){
        this.demo = new SauceDemo(this);

    }
    @Test(dataProvider = "SauceValidAll",dataProviderClass = SauceData.class,priority = 3)
    public  void loginValidCredentials(String username, String password){
       demo.login(username,password);
    }
/*
    @Test(dataProvider = "SauceInvalidpassword",dataProviderClass = SauceData.class,priority = 0)
    public  void loginValidUsernameInvalidPassword(String username, String password){
        demo.login(username,password);
    }
    @Test(priority = 1)
    public void loginInvalidUsernameValidpassword( ){
        demo.login(getConfig().getProperty("invalidusername"),getConfig().getProperty("validpasssword"));
    }

    @Test(priority = 2)
    public  void  verifyLoginButtonAndLogoText(){

        demo.verifyLoginButtontext();
        demo.verifySauceLogo();
    }*/

}
