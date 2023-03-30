package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * TASK: NEW METHOD CREATION
 * Method Name: getDriver
 * Static void
 * Accepts String arg: browserType
 *  -This argument will determine what type of browser is opened
 *  - if "chrome" Passed --> it will open chrome browser
 *  - if "firefox" passed --> it will open firefox browser
 * Return type: "WebDriverFactory;
 */


public class WebDriverFactory {

    public static WebDriver getDriver(String browserType) {

        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        } else if (browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        } else {
            System.out.println("Given browser type does not exist. Driver = null");
            return null;
        }

    }












}
