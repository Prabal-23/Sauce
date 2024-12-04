import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interview {


    @Test
    public void methodTest() {
        String s= "admin/orders/";
          String regex = "/$";

          s=s.replaceFirst(regex,"");

          System.out.println(s);



        /*char [] ch = s.toCharArray();

        if (ch[s.length()-1]=='/'){
            s=s.substring(0,s.length()-1);
        }
System.out.println(s);*/
    }




    @Test
    public void myTest(){
WebDriver driver = new ChromeDriver() ;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofSeconds(5));
        wait.ignoring(NoSuchElementException.class);

WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(""))));

        Assert.assertTrue(element.isDisplayed());

    }



    @Test
    public void  testAgain(){
        String  s ="Monday Tuesday Wednesday";

        char [] ch = s.toCharArray();
        String str ="";
        for (char c: ch){

                if (c=='a'||c=='e' || c=='i' || c=='o' ||c=='u'){
                    str = str;
                }
                else {
                    str=str+c;
                }


        }

        System.out.println(str);

        String [] s1 = str.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(s1));
        System.out.println(list);



    }




}
