package com.cybertek.tests.day13_actionPractices;

import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.utilities.Driver;
import org.junit.Assert;
import org.junit.Test;

public class PageObjectModelPractices {
    @Test
    public void negative_Login_To_Library(){
        // 1- Go to Library
        Driver.getDriver().get("https://library2.cybertekschool.com/login.html");
        ///Create object of the class
        // When we create the object of LibraryLoginPage, constructor will automatically
        // initialize driver and object of LibraryLoginPage
        // Meaning we will be able to use the selenium method through the object of the class
        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();

        // 2- Enter incorrect username
        libraryLoginPage.inputEmail.sendKeys("wrong@gmail.com");

        // 3- Enter incorrect password
        libraryLoginPage.inputPassword.sendKeys("wrong password");
        // click to sign in button
        libraryLoginPage.signInButton.click();
        // 4- Verify error message is displayed
        libraryLoginPage.signInButton.click();
        //5- verify error message is displayed
        Assert.assertTrue(libraryLoginPage.incorrectEmailOrPasswordError.isDisplayed());

    }
}
