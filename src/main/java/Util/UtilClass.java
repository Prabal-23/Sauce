package Util;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.HasCdp;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v115.network.Network;
import org.openqa.selenium.devtools.v115.storage.Storage;
import  org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.devtools.v85.applicationcache.ApplicationCache;

import org.openqa.selenium.html5.LocalStorage;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class UtilClass {


    private static DevTools devTools=null;

    private  static JavascriptExecutor  js;

    public static Properties getPropertiesFile(String file) {
        Properties prop = new Properties();

        try (InputStream input = UtilClass.class.getClassLoader().getResourceAsStream(file)) {
            if (input == null) {
                throw new IllegalArgumentException("Unable to find the properties file: " + file);
            }

            prop.load(input);
        } catch (IOException e) {
            System.err.println("Error in loading config file: " + e.getMessage());
        }

        return prop;
    }



    public String getLocalStorageItem(WebDriver driver, String key) {
         js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return window.localStorage.getItem(arguments[0]);", key);
    }

    public boolean isLocalStorageAvailable(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Boolean) js.executeScript("return typeof window.localStorage !== 'undefined';");
    }

    public boolean isLocalStorageKeyExist(WebDriver driver, String key) {
        js = (JavascriptExecutor) driver;
        Boolean b = (Boolean) js.executeScript("return window.localStorage.getItem(arguments[0]) !== null;", key);
        return b;
    }
    public boolean isKeyHasValue(WebDriver driver, String key) {
        js = (JavascriptExecutor) driver;

        String value = (String) js.executeScript("return window.localStorage.getItem(arguments[0]);", key);

        return value != null && !value.isEmpty();
    }

    public String getCookieValue(String key,WebDriver driver){
        Cookie cookie = driver.manage().getCookieNamed(key);

           return cookie.getValue();
        }


}
