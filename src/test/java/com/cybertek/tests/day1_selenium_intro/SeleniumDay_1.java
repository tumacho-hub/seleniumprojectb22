package com.cybertek.tests.day_1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDay_1 {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
// this line will basically maximize the browser
        driver.manage().window().maximize();

        driver.get("https://www.tesla.com");

        System.out.println("Current title: " + driver.getTitle());

        String  currentUrl = driver.getCurrentUrl();

        System.out.println("currentUl:" + currentUrl);

         driver.navigate().back();

        Thread.sleep(3000);


        driver.navigate().forward();

        Thread.sleep(3000);

        driver.navigate().refresh();
// this line will basically maximize the browser
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");

        driver.getTitle();

        System.out.println("Current title: " + driver.getTitle());

        currentUrl = driver.getCurrentUrl();


        System.out.println("currentUl:" + currentUrl);

        // this method will close the currently opened browser
        // it will only close one browser or tab
        driver.close();




    }
}
