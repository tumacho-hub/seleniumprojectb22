package com.cybertek.utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class officeHoursUtils {

    static String userName = new Faker().name().username();
    static String password = userName.substring(1,3)+"123";
    public static WebElement userNameBox (WebDriver driver){
        return driver.findElement(By.name("username"));

    }

    public static WebElement passwordBox(WebDriver driver) {
        return driver.findElement(By.name("password"));

    }


    public static void addUserTest(WebDriver driver, String url) {
        driver.get(url);
        userNameBox(driver).sendKeys(userName);
        passwordBox(driver).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='FormsButton2']")).click();
    }

    public static boolean positiveLoginTest(WebDriver driver, String url) {
        driver.get(url);
        userNameBox(driver).sendKeys(userName);
        passwordBox(driver).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Test Login")).click();
        WebElement successMessages = driver.findElement(By.xpath("//b[.='**Successful Login**']"));
        return successMessages.isDisplayed();
    }

    public static boolean negativeLoginTests(WebDriver driver, String url) {
        driver.get(url);
        userNameBox(driver).sendKeys(userName.substring(1));
        passwordBox(driver).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Test Login']")).click();
        WebElement failMessage = driver.findElement(By.xpath("//b[.='**Failed Login**']"));
        return failMessage.isDisplayed();

    }



    public  static int productAdder(WebDriver driver, String category, String product) {
//        String category = "Laptops";
//        String locatorCategory = "//a[.='"+category+"']";

        // this method is dynamic because we can reassigned the or change the value of the variables
        // we using string manipulation and concatenation as well. PLEASE REVIEW THE CODE AND METHOD
        driver.findElement(By.xpath("//a[.='" + category + "']")).click();
        BrowserUtils.sleep(1);
        driver.findElement(By.xpath("//a[.='" + product + "']")).click();
        BrowserUtils.sleep(1);

        String amountString = driver.findElement(By.xpath("//h3[@class='price-container']")).getText();
        String[] arrayAmount = amountString.split(" ");
        int amount = Integer.parseInt(arrayAmount[0].substring(1));


        driver.findElement(By.xpath("//a[.='Add to cart']")).click();
        BrowserUtils.sleep(1);
        Alert alert = driver.switchTo().alert(); // this is how we handle the popup!!
        alert.accept();// handle popup!!
        BrowserUtils.sleep(1);
        driver.findElement(By.xpath("(//a[@class='nav-link'])[1]")).click();

        return amount;


    }
// this second method we are creating will reach the deleted button another requirement
    public static int productRemover(WebDriver driver, String product){
 // //tbody//tr//td[.='Apple monitor 24']/..//td[.='Delete']/a

        driver.findElement(By.xpath("//a[.='Cart']")).click();
        BrowserUtils.sleep(1);
        int amount = Integer.parseInt(driver.findElement(By.xpath("//tbody//tr//td[.='"+product+"']/..//td[3]")).getText());
        driver.findElement(By.xpath("//tbody//tr//td[.='"+product+"']/..//td[.='Delete']/a")).click();
        BrowserUtils.sleep(3);

        return amount;

    }
}
