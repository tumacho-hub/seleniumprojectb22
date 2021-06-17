package com.cybertek.tests.Practice_Selenium.SmartBear;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.SmartBearUtils;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
TC#2: Smartbear software order placing
1.Open browser
2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3.Enter username: “Tester”
4.Enter password: “test”
5.Click on Login button
6.Click on Order
7.Select familyAlbum from product, set quantity to 2
8.Click to “Calculate” button
9.Fill address Info with JavaFaker•Generate: name, street, city, state, zip code
10.Click on “visa” radio button
11.Generate card number using JavaFaker
12.Click on “Process”
13.Verify success message “New order has been successfully added.”
 */
public class SmartBear2 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }


    @Test
    public void windowTest(){
        SmartBearUtils.SmartBear(driver);

 //7.Select familyAlbum from product, set quantity to 2

        WebElement order = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        order.click();




        BrowserUtils.sleep(1);
        WebElement familyProduct = driver.findElement(By.xpath("//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']//option[2]"));
       familyProduct.click();

       WebElement quantity = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));
       quantity.sendKeys("2");

       //8.Click to “Calculate” button

        WebElement calculate = driver.findElement(By.xpath("//input[@type='submit']"));
        calculate.click();
//9.Fill address Info with JavaFaker•Generate: name, street, city, state, zip code

        WebElement customerName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));

        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']")).sendKeys(faker.address().streetAddress());
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']")).sendKeys(faker.country().capital());
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']")).sendKeys(faker.nation().capitalCity());
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']")).sendKeys(faker.number().digits(5));
//10.Click on “visa” radio button

        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']")).click();

//11.Generate card number using JavaFaker
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']")).sendKeys(faker.number().digits(16));

        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']")).sendKeys("0");
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']")).sendKeys(faker.number().digit());

        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']")).sendKeys("/");
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']")).sendKeys(String.valueOf(faker.number().numberBetween(20,25)));

       // 12.Click on “Process”
       WebElement process = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
       process.click();
//13.Verify success message “New order has been successfully added.”


        String expectedResult = process.getText();

        System.out.println("New order has been successfully added. == " + expectedResult);


    }



}
