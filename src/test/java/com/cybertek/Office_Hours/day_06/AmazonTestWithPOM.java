package com.cybertek.Office_Hours.day_06;

import com.cybertek.pages.AmazonPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonTestWithPOM {
    // go to https://www.Amazon.com

    @Test
    public void testAmazon(){
        // opening page
       Driver.getDriver().get(ConfigurationReader.getProperty("amazon"));
        BrowserUtils.sleep(1);

        // creating object to reach POM variables and methods
        AmazonPage amazonPage = new AmazonPage();

        //get the list of all the tabs
        List<WebElement> tabsElement = amazonPage.tabs;

        for (int i = 0; i < tabsElement.size(); i++) {
           // System.out.println("tabsElement.get(i).getText() = " + tabsElement.get(i).getText());
            String Text = amazonPage.tabs.get(i).getText();
            amazonPage.Tab(Text).click();
        }
        amazonPage.searchBox.sendKeys(ConfigurationReader.getProperty("searchAmazon") + Keys.ENTER);

    }
}
