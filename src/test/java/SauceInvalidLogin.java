import Base.SauceBaseClass;
import PageObjects.SaucePage;
import Module.SauceDemo;
import org.testng.annotations.*;
import DataProvider.SauceData;

public class SauceInvalidLogin extends SauceBaseClass {



SauceDemo demo=null;
    @Parameters({"browser"})
    @BeforeClass
    public void initializesClasse(@Optional("chrome") String browser){
        configureBrowser(browser);
        this.demo = new SauceDemo(this);

    }

    @Test(dataProvider = "SauceInvalidpassword",dataProviderClass = SauceData.class,priority = 0)
    public  void loginValidUsernameInvalidPassword(String username, String password){
        demo.login(username,password);
        demo.verifyUserisNotLoggedIn();
        demo.verifyLoginFailedMesage();
    }
    @Test(priority = 1)
    public void loginInvalidUsernameValidpassword( ){
        demo.login(getConfig().getProperty("invalidusername"),getConfig().getProperty("validpasssword"));
        demo.verifyUserisNotLoggedIn();
        demo.verifyLoginFailedMesage();

    }

    @Test(priority = 2)
    public  void  verifyLoginButtonAndLogoText(){

        demo.verifyLoginButtontext();
        demo.verifySauceLogo();
    }
@AfterClass
public void tearDownMethod(){

    closebrowser();
}
}
