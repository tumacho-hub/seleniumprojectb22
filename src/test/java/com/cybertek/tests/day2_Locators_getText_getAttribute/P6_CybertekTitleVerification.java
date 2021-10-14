package com.cybertek.tests.day2_Locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P6_CybertekTitleVerification {
    public static void main(String[] args) throws InterruptedException {
        /*
        1- open chrome browser
        2- go to htpp://practice.cybertekschool.com/inputs
        3- click "home" button
        4 verify tittle as expected

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

       driver.get("http://practice.cybertekschool.com/inputs");

//  step 3. click "home" button
//  first locate the web element using class attribute value
 // second click
       Thread.sleep(3000); //  this method will delay the process

        driver.findElement(By.className("nav-link")).click();

      //  4 verify tittle as expected
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED");
        }else{
            System.out.println("Tittle verification FAILED");
        }







    }
}
