package com.cybertek.tests.day12_action_upload_isexecutor;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class uploadPractice {

    @Test
    public void uploadTest(){
        // 1- go to http://practice.cybertekschool.com/upload
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");

        // find some small file from you computer, and get the path of it.

        String path = "C:\\Users\\coquiz\\Desktop\\Nadir's project\\Screen_Shot_2021-06-19_at_10.38.08_AM.png";

        // 3- upload the file
        WebElement chooseFile =  Driver.getDriver().findElement(By.id("file-upload"));
        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        BrowserUtils.sleep(3);

        chooseFile.sendKeys(path);

        uploadButton.click();

        //4- Assert:
        // file uploaded text is displayed on the page
        WebElement fileUploadedMessage =  Driver.getDriver().findElement(By.tagName("h3"));

        Assert.assertTrue(fileUploadedMessage.isDisplayed());

        Driver.closeDriver();
    }
}
