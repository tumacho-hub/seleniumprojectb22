package com.cybertek.tests.day6_testing_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Find_Elements_Apple {
    public static void main(String[] args) throws InterruptedException {

//        TC #03: FINDELEMENTS_APPLE
//        1.Open Chrome browser
//        2.Go to https://www.apple.com
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("https://www.apple.com");
//
//
//        3.Click to all of the headers one by one apple, Mac, iPad, iPhone, Watch, TV, Music, Support
        // the variable below is helping us to store 9 links that we we need to locate from apple headers
        List<WebElement> headerLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li/a"));

        // lest create a regular for loop because we need to loop through every single link.

     for (int eachLink = 1; eachLink < headerLinks.size()-1; eachLink++){
     //    System.out.println(headerLinks.get(eachLink).getText());

         headerLinks.get((eachLink)).click();
         Thread.sleep(1000);
         // after we run the code we get StaleElementReferenceException because our driver after refreshing is loosing its reference
         //  so we need to refresh the reference of the page.. basically we are restoring the variables again
          headerLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li/a"));// we are refreshing the elements

//        4.Print out total number of links in each page
         System.out.println("Current title in the page: " + driver.getTitle());
//
//        5.Print out total number of links in each page
         List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));//"//body//a" => it returning all the links inside of the body
         System.out.println("number of links in current page: " + allLinks.size());

         int linksWithNoText = 0;
         int linksWithText = 0;
         for (WebElement each : allLinks){
             if (each.getText().isEmpty()){
                 linksWithNoText++;
             }else {
                 linksWithText++;
             }
         }

//        6.While in each page:a.Print out how many link is missing textTOTALb.
         System.out.println("Current page links with no text: "+ linksWithNoText);
//        Print out how many link has textTOTAL
         System.out.println("Current page links with text: " + linksWithText);

         headerLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li/a"));

        }
    }
}