package com.cybertek.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class officeHoursUtils {

    public  static void productAdder(WebDriver driver, String category, String product) {
//        String category = "Laptops";
//        String locatorCategory = "//a[.='"+category+"']";

        // this method is dynamic because we can reassigned the or change the value of the variables
        // we using string manipulation and concatenation as well. PLEASE REVIEW THE CODE AND METHOD
        driver.findElement(By.xpath("//a[.='" + category + "']")).click();
        BrowserUtils.sleep(1);
        driver.findElement(By.xpath("//a[.='" + product + "']")).click();
        BrowserUtils.sleep(1);
        driver.findElement(By.xpath("//a[.='Add to cart']")).click();
        BrowserUtils.sleep(1);
        Alert alert = driver.switchTo().alert(); // this is how we handle the popup!!
        alert.accept();// handle popup!!
        BrowserUtils.sleep(1);
        driver.findElement(By.xpath("(//a[@class='nav-link'])[1]")).click();


    }
// this second method we are creating will reach the deleted button another requirement
    public static void productRemover(WebDriver driver, String product){
 // //tbody//tr//td[.='Apple monitor 24']/..//td[.='Delete']/a

        driver.findElement(By.xpath("//a[.='Cart']")).click();
        BrowserUtils.sleep(1);
        driver.findElement(By.xpath("//tbody//tr//td[.='"+product+"']/..//td[.='Delete']/a")).click();
        BrowserUtils.sleep(3);

    }
}
