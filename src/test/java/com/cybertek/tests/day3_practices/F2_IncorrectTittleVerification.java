package com.cybertek.tests.day3_practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class F2_IncorrectTittleVerification {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        //create driver instance and open browser
        WebDriver driver = new ChromeDriver();

 //       WebDriver = WebDriverFactory.getDriver("chrome"); simplification of the lines above we just created a new method util in selenium

        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        WebElement inputUsername = driver.findElement(By.id("email"));

        inputUsername.sendKeys("something1213@gmail.com");

        WebElement inputPassword = driver.findElement(By.id("pass"));

        inputPassword.sendKeys("some wrong password" + Keys.ENTER);

        Thread.sleep(5000);
        String expectedTitle = "Log into Facebook";
        System.out.println("expectedTitle =" + expectedTitle);

        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification Passed");
        } else {
            System.out.println("Title verification Failed");

        }
    }
}
