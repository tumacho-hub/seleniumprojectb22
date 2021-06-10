package com.cybertek.tests.day5_findElements_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P0_findElements_Practice {
    public static void main(String[] args) {
        /*

TC #0: FINDELEMENTS
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_password
3. Print out the texts of all links
4. Print out how many total link
*/
        //TC #1: FINDELEMENTS
        //1. Open Chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // If a web element is not found, this will wait UP TO given seconds
        // If web element is located before 15 seconds, it will move on
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //WE NEED TO CREATE A LOCATOR THAT RETURNS US ALL THE LINKS ON THE PAGE
        //body//a ---> This locator will return all of the links on the page
      List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));
      // iter + tab ==> shortcut for foreach loop
        // fori + tab ==> shortcut for regular for loop

        //3. Print out the texts of all links
        for (WebElement each : listOfLinks) {

            System.out.println(each.getText());
            System.out.println(each.getAttribute("href")); // this will give me the attributes of the links

            int numberOfLinks =  listOfLinks.size();


            System.out.println("numberOfLinks = " + numberOfLinks);

        }


    }

}
