package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LibraryUtils {
    // first we made this method static so we can call by the method name!!
    // second we need to make this method method accept an argument
    public static void loginToLibrary(WebDriver driver){
        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='inputEmail']"));
        inputUsername.sendKeys("student11@library");
//    4.Enter password:""
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='inputPassword']"));
        inputPassword.sendKeys("tScBPCUr");

//    5.Click to Login button

        WebElement loginButton = driver.findElement(By.xpath("//button[.='Sign in']"));
        loginButton.click();
    }
}
