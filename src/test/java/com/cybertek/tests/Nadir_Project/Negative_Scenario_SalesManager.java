package com.cybertek.tests.Nadir_Project;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Negative_Scenario_SalesManager {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://qa3.vytrack.com/user/login");

        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager153" + Keys.ENTER);

        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);

        String userName = "salesmanager253";
        String Password = "UserUser123";

        if (userName.equals("salesmanager153") && Password.equals("UserUser123")) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Invalid user name or password.");


        }


    }
}

