import Base.SauceBaseClass;
import Screenshots.ScreenShot;
import Screenshots.ScreenShot;
import Module.SauceDemo;
import org.testng.ITestResult;
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
        demo.verifyLoginFailedMesage();
    }
    @Test(priority = 1)
    public void loginInvalidUsernameValidpassword( ){
        demo.login(getConfig().getProperty("invalidusername"),getConfig().getProperty("validpasssword"));
        demo.verifyUserisNotLoggedIn();
        demo.verifyLoginFailedMesage();

    }

    @Test
    public void blankPasswordLogin(){
        demo.login(getConfig().getProperty("valiusrename"),"");
        demo.verifyBlankpasswordMessage();
    }

    @Test public void blankUsername(){
        demo.login("",getConfig().getProperty("validpasssword"));
        demo.verifyBlankusernameMessage();
    }

    @Test public void bothFieldBlank(){

        demo.login("","");
        demo.verifyBlankusernameMessage();
    }

    @Test(priority = 2)
    public  void  verifyLoginButtonAndLogoText(){

        demo.verifyLoginButtontext();
        demo.verifySauceLogo();
    }

    @AfterMethod
    public void captureScreenShotAfterTestMethod(ITestResult result){
        String testName = result.getName();
        ScreenShot.captureScreenshot(getbaseDriver(), testName);
        System.out.println("Screenshot captured for: " + testName);

    }
@AfterClass
public void tearDownMethod(){

    closebrowser();
}
}
