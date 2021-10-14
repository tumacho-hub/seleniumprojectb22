package com.cybertek.tests.Practice_Selenium.Upload_hover_over;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tc14_Upload_Test {
    /*
    TC #14: UploadTest
    1.Go to http://practice.cybertekschool.com/upload
    2.Find some small file from your computer, and get the path of it.
    3.Upload the file.
    4.Assert: -File uploaded text is displayed on the page
     */

    @Test
    public void uploadTest() {
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");

        //2.Find some small file from your computer, and get the path of it.
        String path = "C:\\Users\\coquiz\\Desktop\\Nadir's project\\1w06g8.jpg";

        WebElement chooseFile = Driver.getDriver().findElement(By.id("file-upload"));
        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));

        chooseFile.sendKeys(path);
        uploadButton.click();

        WebElement fileUploadedMessage = Driver.getDriver().findElement(By.tagName("h3"));

        Assert.assertTrue(fileUploadedMessage.isDisplayed());



    }
}
