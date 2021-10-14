package com.cybertek.tests.day2_Locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_EtsySearch_TitleVerification {
    public static void main(String[] args) {
        /*
        1- open chrome browser
        2- go to https://www.etsy.com
        3- search for "wooden spoon"
        4- verify tittle
        EXpected: "wooden spoon | etsy
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com");
        /*
        first we need to locate the search bar
        second we enter search value
        third we press enter
         */

        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("Wooden Spoon" + Keys.ENTER);

        String expectedTitle = "Wooden Spoon | Etsy";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Etsy Title verification Passed");
        }else{
            System.out.println("Etsy Title verification Failed");
        }

    }
}
