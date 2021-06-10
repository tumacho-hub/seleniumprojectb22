package com.cybertek.tests.day5_findElements_checkboxes.Find_Elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElements {
    /*
    TC #0: FINDELEMENTS
    1.Open Chrome browser
    2.Go to https://www.merriam-webster.com/
    3.Print out the texts of all links
    4.Print out how many link is missing text
    5.Print out how many link has text
    6.Print out how many total link
     */
    WebDriver driver;
    @BeforeMethod
    public void setupDriver(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.merriam-webster.com/");
    }
    @Test
    public void windowTester(){
      // this is  how find the list of links in the web page example below
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        //3.Print out the texts of all links

        for (WebElement each : listOfLinks){

            System.out.println(each.getText());
          // link below will get all of the links in the page
            System.out.println(each.getAttribute("href"));



        }
        int numberOfLinks =  listOfLinks.size();
        System.out.println("Number of links =" + numberOfLinks);
    }
}
