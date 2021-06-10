package com.cybertek.tests.day5_findElements_checkboxes.Find_Elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElements_Apple {
    /*
    TC #02: FINDELEMENTS_APPLE
    1.Open Chrome browser
    2.Go to https://www.apple.com
    3.Click to iPhone
    4.Print out the texts of all links
    5.Print out how many link is missing text
    6.Print out how many link has text
    7.Print out how many total link
     */
    WebDriver driver;
    @BeforeMethod
    public void setupDriver(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.apple.com");
    }
    @Test
    public void windowTest(){
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        for (WebElement each : listOfLinks){
  //          4.Print out the texts of all links
        //    System.out.println(each.getText());
            System.out.println(each.getAttribute("href"));

        }
      int numberOfLinks = listOfLinks.size();
        System.out.println("numberOfLinks = " + numberOfLinks);


    }
}
