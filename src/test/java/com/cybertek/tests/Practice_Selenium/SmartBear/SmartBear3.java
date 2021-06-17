package com.cybertek.tests.Practice_Selenium.SmartBear;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.SmartBearUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
TC#3: Smartbear software order verification
1.Open browser and login to Smartbear software
2.Click on View all orders
3.Verify Susan McLaren has order on date “01/05/2010”
 */
public class SmartBear3 {

WebDriver driver;

@BeforeMethod
    public void setupMethod(){
    driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");



    }

    @Test
    public void windowTest(){
        SmartBearUtils.SmartBear(driver);

        WebElement viewOrder = driver.findElement(By.cssSelector("a[href='Default.aspx']"));
        viewOrder.click();
//3.Verify Susan McLaren has order on date “01/05/2010”
        WebElement date = driver.findElement(By.xpath("//tbody/tr/td[.='01/05/2010']"));

        System.out.println("Date is == " + date.getText());


}
}
