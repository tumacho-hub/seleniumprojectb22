package com.cybertek.Office_Hours.day03;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.utilities.officeHoursUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
OscarS — 06/05/2021
In this task we will handle alerts, we will create a method that can be used in our test case for repeated actions. Try to stick to DRY (don't repeat yourself) concept.
If something is repeating try to create a solution for that.
You have to implement the following Web automated checks over our (Adifas) DEMO ONLINE SHOP: https://www.demoblaze.com/index.html
• Customer navigation through product categories: Phones, Laptops and Monitors
• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
• Navigate to "Phones" → "Samsung galaxy s6" and click on "Add to cart". Accept pop up confirmation.
• Navigate to "Monitors" → "Apple monitor 24" and click on "Add to cart". Accept pop up confirmation.
• Navigate to "Cart" → Delete "Apple monitor 24" from cart.
• Click on "Place order".
• Fill in all web form fields.
• Click on "Purchase"
• Capture and log purchase Id and Amount.
• Assert purchase amount equals expected.
• Click on "Ok"
STORE
for this task we practicing pop up alert
web tables
creating utility class
Dynamic locators
String manipulation
also practice faker class
bad ass project ;p
 */
public class Adidas_part1 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.demoblaze.com/index.html");

    }

    public void productAdder(String category, String product) {
//        String category = "Laptops";
//        String locatorCategory = "//a[.='"+category+"']";
        driver.findElement(By.xpath("//a[.='" + category + "']")).click();
        BrowserUtils.sleep(1);
        driver.findElement(By.xpath("//a[.='" + product + "']")).click();
        BrowserUtils.sleep(1);
        driver.findElement(By.xpath("//a[.='Add to cart']")).click();
        BrowserUtils.sleep(1);
        Alert alert = driver.switchTo().alert(); // this is how we handle the pop ups!!
        alert.accept();// handle pop ups!!
        BrowserUtils.sleep(1);
        driver.findElement(By.xpath("(//a[@class='nav-link'])[1]")).click();


    }

    @Test
    public void adidasTest() {
        // this is how we started our code!!
//  String category = "Laptops";
////        String locatorCategory = "//a[.='"+category+"']";
//        driver.findElement(By.xpath("//a[.='Laptops']")).click();
//    BrowserUtils.sleep(1);
//    driver.findElement(By.xpath("//a[.='Sony vaio i5']")).click();
//    BrowserUtils.sleep(1);
//    driver.findElement(By.xpath("//a[.='Add to cart']")).click();
//    BrowserUtils.sleep(1);
//    Alert alert = driver.switchTo().alert(); // this is how we handle the popup!!
//    alert.accept();// handle popup!!
//    BrowserUtils.sleep(1);
//    driver.findElement(By.xpath("(//a[@class='nav-link'])[1]")).click();
        //• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
        officeHoursUtils.productAdder(driver, "Laptops", "Sony vaio i5");

        //• Navigate to "Phones" → "Samsung galaxy s6" and click on "Add to cart". Accept pop up confirmation.
        officeHoursUtils.productAdder(driver, "Phones", "Samsung galaxy s6");
        // • Navigate to "Monitors" → "Apple monitor 24" and click on "Add to cart". Accept pop up confirmation.
        // the line below is failing because we need to pass the driver from the other method
        officeHoursUtils.productAdder(driver, "Monitors", "Apple monitor 24");

        // now we are removing apple monitor 24
        officeHoursUtils.productRemover(driver,"Apple monitor 24");

        driver.findElement(By.xpath("//button[.='Place Order']")).click();

        Faker faker = new Faker();
        driver.findElement(By.id("name")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("country")).sendKeys(faker.country().name());
        driver.findElement(By.id("city")).sendKeys(faker.country().capital());
        driver.findElement(By.id("card")).sendKeys(faker.finance().creditCard());
        // for the las line because we using int but expecting a string we can use
        // WRAPPERCLASS  STRING.valueof
        // TO GET THIS FIX
     //   driver.findElement(By.id("month")).sendKeys(faker.number().numberBetween(1, 12));
        driver.findElement(By.id("month")).sendKeys(String.valueOf(faker.number().numberBetween(1, 12)));
        driver.findElement(By.id("year")).sendKeys(String.valueOf(faker.number().numberBetween(2022, 2030)));

        // Click on "Purchase"
         driver.findElement(By.xpath("//button[.='Purchase']")).click();
         BrowserUtils.sleep(1);

         // Capture and log purchase Id and Amount.
        String confirmation = driver.findElement(By.xpath("//p[@class='lead text-muted ']")).getText();
        System.out.println("confirmation = " + confirmation);
 // we can split the confirmation number with nextLine regex

        String[] confirmationArray = confirmation.split("\n");
        String orderID = confirmationArray[0];
        System.out.println("orderID = " + orderID);
 // the line below we also having a new error because we are going from int to Array Integer []
        // for this case we need to use WRAPPERCLASS from in to integer
        int actualAmount = Integer.parseInt(confirmationArray[1].split( " ")[1]);
        System.out.println("actualAmount = " + actualAmount);
        int expectedAmount = 1150;

        Assert.assertEquals(actualAmount,expectedAmount);


    }


    }



