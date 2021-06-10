package com.cybertek.tests.day4_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P6_xpath_MultipleButtons {
    public static void main(String[] args) {
        /*
        //TC#6: XPATH LOCATOR prsactice
        //1. Open Chrome browser
        //2. go to http://practice.cybertekschool.com/multiple_buttons
        //3. Click on Button 1
        //4. Verify text displayed is as expected
        //Expected: "click on button one!"
         */
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        //2. go to http://practice.cybertekschool.com/multiple_buttons

        driver.get(" http://practice.cybertekschool.com/multiple_buttons");

        //3. Click on Button 1
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));

        button1.click();

        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        String expectedText = "Clicked on button one!";
        String actualText = resultText.getText();

        if (actualText.equals(expectedText)) {
            System.out.println("Result verification PASSED");
        }else{
            System.out.println("Result text verification FAILED!!!");
        }


    }
}
