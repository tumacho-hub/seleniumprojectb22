package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    // we just created a private constructor ==   private Driver(){
    /*
    creating the private constructor so thi class object is not reachable form outside
     */

    private Driver(){

    }
    private static WebDriver driver;
    // creating re-usable utility method that will return same driver instance everytime we call it.
    public static WebDriver getDriver() {
        if (driver == null) {
// we read our browser type from configuration.properties file using
// .getProperty method we creating in configurationReader class.
            String browserType = ConfigurationReader.getProperty("browser");
// depending on the browser type our switch statement will determine to open specific type of browser/driver
            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }


        }
        // same driver instance will be returned every time we call driver.getDriver(); method
        return driver;


    }
    /*
    this method make sure we have some form of driver sesion or driver id has.
    Either null or not null it must exist.
     */
    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
