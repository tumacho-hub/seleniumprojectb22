package com.cybertek.tests.day12_action_upload_isexecutor;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class JSExecuterPractice {
    @Test
    public void scroll_using_jsExecutor_test1() {
        // get the page: http://practice.cybertekschool.com/infinite_scroll
        Driver.getDriver().get("http://practice.cybertekschool.com/infinite_scroll");
//  DownCasting our driver type to JavaScriptExecutor so we can reach methods in this interface
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        // using the js we reach executeScrip method so we are allowed to pass JavaScrip functions
        // this method is capable of accepting JavaScript functions and apply that into our Java+Selenium code
        //   js.executeScript("window.scrollBy(0, 750)");

        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,7500)");

        }
    }
}
