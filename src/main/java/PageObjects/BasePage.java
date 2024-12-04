package PageObjects;

import Base.SauceBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public  class BasePage  extends   RemoteWebElement{

    private SauceBaseClass baseClass = null;
   private static WebDriver driver = null;
   private  WebElement element1=null;

   private JavascriptExecutor js = null;


   public  BasePage (WebElement element){
       this.element1=element;
   }

    public BasePage(SauceBaseClass baseClass) {
        this.baseClass=baseClass;
        this.driver=baseClass.getbaseDriver();

    }


    public void clickElementSafely(By locator) {
        js=(JavascriptExecutor) driver;
        try {
            baseClass.wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(getElementsafely(locator))));
            js.executeScript("arguments[0].click();", getElementsafely(locator));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public void sendKeysSafely(By locator, String text) {
        try {
            js=(JavascriptExecutor) driver;

            baseClass.wait.until(ExpectedConditions.visibilityOf(getElementsafely(locator)));
            baseClass.wait.until(ExpectedConditions.elementToBeClickable(getElementsafely(locator)));
            getElementsafely(locator).clear();
            getElementsafely(locator).sendKeys(text);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public  String getText() {

        System.out.println("This is invoked");
        String text =element1.getText();

        if (text == null || text.isEmpty()) {
            text = element1.getAttribute("value");
        }
        System.out.println(text);
        return text.trim();
    }


    public  String getTextsafely(WebElement element){
      String s= new BasePage(element).getText();
       return  s;
    }

    public WebElement getElementsafely(By locator){
        return baseClass.wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply( WebDriver webDriver) {
                return driver.findElement(locator);
            }
        });
    }
    public List<String> getStringListFromElementList(List<WebElement> element){

        List<String> listtext = new ArrayList<>();
        for(WebElement ee:element){
            listtext.add(ee.getText());
            System.out.println("Adding element to String List");
            System.out.println(listtext);
        }
        return listtext;
    }


}