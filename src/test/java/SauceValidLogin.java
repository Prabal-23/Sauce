import Base.SauceBaseClass;
import DataProvider.SauceData;
import org.testng.annotations.*;
import Module.SauceDemo;

public class SauceValidLogin extends SauceBaseClass {


    SauceDemo demo=null;

    @Parameters({"browser"})
    @BeforeMethod
    public void initializeClasses(@Optional("chrome") String browser){
        configureBrowser(browser);
        this.demo = new SauceDemo(this);
        demo.verifyIfLocalStorageExist();
        demo.verifyIfKeyHasSomeValueInLocalStorage(getConfig().getProperty("key1"));
        demo.verifyIfKeyHasSomeValueInLocalStorage(getConfig().getProperty("key2"));

    }

    @Test(dataProvider = "SauceValidAll",dataProviderClass = SauceData.class,priority = 3)
    public  void loginValidCredentials(String username, String password){
        demo.login(username,password);
        demo.verifyLoginIsSucessFul();
        demo.getCookieValueBykey(getConfig().getProperty("usernamekey"),username);

    }

    @AfterMethod
    public void tearDownMethod(){
        demo.verifyIfLocalStorageExist();
        demo.verifyIfKeyHasSomeValueInLocalStorage(getConfig().getProperty("key1"));
        demo.verifyIfKeyHasSomeValueInLocalStorage(getConfig().getProperty("key2"));

        closebrowser();
    }
}
