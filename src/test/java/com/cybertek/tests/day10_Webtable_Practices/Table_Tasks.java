package com.cybertek.tests.day10_Webtable_Practices;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TableUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Table_Tasks {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod() {

        String browser = ConfigurationReader.getProperty("browser");
        // this line is returning String chrome
        String url = ConfigurationReader.getProperty("dataTableUrl");
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);

      //  driver.get(ConfigurationReader.getProperty("dataTableUrl"));
    }


        @Test
    public void task3_return_tims_due_amount(){
        /*
        // 1. open browser and go to http://practice.cybertekschool.com/tables#edit
        // 2. locate first table verify Tim has due amount of "$50"
        This is an example of how to locate dynamic cell this example is tim //table[@id='table1']//td[.='Tim']
        first way to locate the fifty ===>> //table[@id='table1']//td[.='Tim']/../td[4]
        second way to locate the $50 amount ===>> dynamic //table[@id='table1']//td[.='Tim']/following-sibling::td[2]
         */

         WebElement timsDueAmountCell =  driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']/following-sibling::td[2]"));

            System.out.println("timsDueAmountCell = " + timsDueAmountCell.getText());

            String actualTimResult = timsDueAmountCell.getText();
            String expectedTimResult = "$50.00";
            Assert.assertEquals(actualTimResult, expectedTimResult, "Tim's cell is not returning as expected");
        }
        @Test
        public void task4_return_tims_due_amount(){

            TableUtils.verifiedOrder(driver,"Tim");
        }
}
