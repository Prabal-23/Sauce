package Base;

import Util.UtilClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

public class SauceBaseClass {

    private  static WebDriver driver ;
    public static WebDriverWait wait;
    private static Properties config;
    public static final String CONFIG_PROP = "config.properties";




    public WebDriver getbaseDriver(){
        return driver;
    }

    public Properties getConfig() {
        return config;
    }


    @BeforeSuite
    public  void beforeSuite() {

        config = UtilClass.getPropertiesFile(CONFIG_PROP);

    }

        @BeforeClass
    @Parameters({"browser"})
    public void configureBrowser ( @Optional("chrome") String browser){
     if (browser.equals("chrome"))
        {
            driver=new ChromeDriver();
        }

     else if (browser.equals("firfox")){
         driver=new FirefoxDriver();
     }
     getbaseDriver().manage().window().maximize();
     getbaseDriver().get(getConfig().getProperty("url"));

        wait =new WebDriverWait(getbaseDriver(), Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofSeconds(4));
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(ElementNotInteractableException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(NotFoundException.class);
        wait.ignoring(TimeoutException.class);

    }
}
