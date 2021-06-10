package com.cybertek.tests.day7_Alerts_Iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/*
TC #4 : Iframe practice
1. Create a new class called: IframePractice
2. Create new test and make set ups
3. Go to: http://practice.cybertekschool.com/iframe
4. Assert: “Your content goes here.” Text is displayed.
5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
 */
import java.util.concurrent.TimeUnit;

public class Iframe_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/iframe");
    }
    @Test
    public void IframeTes(){

        // #1-> changing to iframe by index: we pass index number
     //   driver.switchTo().frame(0); iframe start from 0!!

        //#2-> locate as web element to switch
        // we find and located <iframe> web element from page
        //WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        //WebElement iframe = driver.findElement(By.xpath("//iframe[@title='Rich Text Area. Press ALT-0 for help.']"));
        //WebElement iframe = driver.findElement(By.xpath("//iframe[@class='tox-edit-area__iframe']"));
        //driver.switchTo().frame(iframe);


        //#3-> id <iframe> tag has id or name attribute, we can pass its attribute value as a string into
        // .switchTo().frame(iframe); method directly
        driver.switchTo().frame("mce_0_ifr");

        // locating web element text
        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));

        // locating web element text
        WebElement youContentGoesHere = driver.findElement(By.xpath("//p"));


        //4. Assert: “Your content goes here.” Text is displayed.
        Assert.assertTrue(yourContentGoesHereText.isDisplayed());

        //    driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();


        // locating header as web element
        WebElement headerText = driver.findElement(By.xpath("//h3"));



 // 5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
        Assert.assertTrue(headerText.isDisplayed());

    }

}
