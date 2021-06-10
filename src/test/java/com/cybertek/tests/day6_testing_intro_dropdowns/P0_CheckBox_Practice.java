package com.cybertek.tests.day6_testing_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class P0_CheckBox_Practice {
    public static void main(String[] args) throws InterruptedException {
//  practice : cybertek checkboxes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //1. go  to http://practice.cybertekschool.com/checkboxes

        driver.get("http://practice.cybertekschool.com/checkboxes");



        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        //2 confirm checkbox #1 is not selected by default
        if (!checkbox1.isSelected()){
            System.out.println("Checkbox1  is not selected. Verification Passed");
        }else{
            System.out.println("Checkbox2 is selected. VerificationFailed ");
        }

        //3. confirm checkbox #2 is selected by default
        if (checkbox2.isSelected()){
            System.out.println("Checkbox2  is  selected. Verification Passed");
        }else{
            System.out.println("Checkbox2 is not selected. VerificationFailed ");
        }


        //4. click checkbox #1 to select it
        Thread.sleep(2000);
        checkbox1.click();


        //5. click checkbox #2 to deselected it.


        Thread.sleep(2000);
        checkbox2.click();
        //6. confirm checkbox #1 is selected.
        if (checkbox1.isSelected()){
            System.out.println("Checkbox1  is selected. Verification Passed");
        }else{
            System.out.println("Checkbox1  is  not selected. VerificationFailed ");
        }

        //7. confirm checkbox #2 is not selected

        if (!checkbox2.isSelected()){
            System.out.println("Checkbox2  is not selected. Verification Passed");
        }else{
            System.out.println("Checkbox1 is selected. VerificationFailed ");
        }


driver.close();

    }
}
