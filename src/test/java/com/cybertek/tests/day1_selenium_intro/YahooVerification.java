package com.cybertek.tests.day1_selenium_intro;
/*
TC #1: Yahoo Title Verification
1. Open Chrome browser


Expected: Yahoo
 */
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooVerification {
    public static void main(String[] args) {

        //        TC #1: Yahoo Title Verification
        WebDriverManager.chromedriver().setup();
//        1. Open Chrome browser

        WebDriver driver = new ChromeDriver();
        // maximize browser
        driver.manage().window().maximize();

//  2. Go to https://www.yahoo.com
         driver.get("https://www.yahoo.com");


         String expectedTitle = "Yahoo";
        System.out.println("expectedTitle = " + expectedTitle);

// where do we get our actual title  value
        System.out.println("expectedTitle = " + expectedTitle);
        String  actualTitle =  driver.getTitle();

// creating our verification
if (actualTitle.equals(expectedTitle)){
    System.out.println("Title is as expected. Verification Passed!");
}else{
    System.out.println("Title is as expected. Verification Failed!");
}
 // closing the driver








    }
}
