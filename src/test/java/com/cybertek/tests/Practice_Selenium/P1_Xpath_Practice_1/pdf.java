package com.cybertek.tests.Practice_Selenium.P1_Xpath_Practice_1;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pdf {
    /*
    XPATH PRACTICES
    DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
    TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
    1. Open Chrome browser
    2. Go to http://practice.cybertekschool.com/forgot_password
    3. Locate all the WebElements on the page using XPATH locator only (total of 6)
    a. “Home” link
    b. “Forgot password” header
    c. “E-mail” text
    d. E-mail input box
    e. “Retrieve password” button
    f. “Powered byCybertek School” text
    4. Verify all WebElements are displayed.
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        //3. Locate all the WebElements on the page using XPATH locator only (total of 6)
  //a.  “Home” link  in order to find this element i need to  create some thing similar like a variable locating the web element
  // tagName means => WebElement the formula is tagName[@attribute='value']
 // my tag name       (formula==> tagName//[@attribute='value']) translation from the inspection
        // first always ("//" is the key) ("a" is my tag) ("class" my attribute) (My value is 'nav-link')
 //  all together this is my Xpath value //a[@class='nav-link'] stick to the main XPATH
// locating with  href                     a[@href='/']
//we also can locate by text formula tagName[.='text']
//                                         a[.='Home']
        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
//    b. “Forgot password” header
//  <h2>Forgot Password</> if we use Xpath locator we just need to h2[.
        WebElement forgotPassword = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
// c. “E-mail” text
        WebElement emailText = driver.findElement(By.xpath("//label[@for='email']"));
//d. E-mail input box
        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
//e. “Retrieve password” button
      WebElement retrievePassword = driver.findElement(By.xpath("//button[@id='form_submit']"));
//f. “Powered byCybertek School” text
// for this one since we have a webLink and text we need to cover two attributes child and parent.
// we will have to start from child and then move to parent solution
// this formula will only cover the child //a[.=Cybertek School'] by adding /.. it will direct to the parent and it will cover those two scenarios
        WebElement footerText = driver.findElement(By.xpath("//a[.='Cybertek School']/.."));
 //4. Verify all WebElements are displayed.

 if (homeLink.isDisplayed() && forgotPassword.isDisplayed()
         && emailText.isDisplayed() && emailInput.isDisplayed() &&
         retrievePassword.isDisplayed() && footerText.isDisplayed()){
     System.out.println("All of the WebElements are display. PASS");
 }else {
     System.out.println("One or more of the web elements are not display. Fail");


 }
    }
}
