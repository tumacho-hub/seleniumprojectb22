package com.cybertek.tests.day7_Alerts_Iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
/*
TC	#	:	Window	Handle practice
1. Create	a	new	class	called:	WindowHandlePractice
2. Create	new	test	and	make	set	ups
3. Go	to	:	http://practice.cybertekschool.com/windows
4. Assert:	Title	is	“Practice”
5. Click	to:	“Click	Here” text
6. Switch	to	new	Window.
7. Assert:	Title	is	“New	Window”
 */
public class Window_Practice_Class {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");


}
@Test
public void window_test(){

        // printing out the window handle of the first page opened
    // storing the first windowHandle into a string is a useful practice for future needs when need it
    // to switch back to it
   String mainHandle = driver.getWindowHandle();
   System.out.println("mainHandle = " + mainHandle);

//    4. Assert:	Title	is	“Practice”
    String actualTitleBeforeClick = driver.getTitle();
    String expectedTitleBeforeClick = "Practice";

    System.out.println("actualTitleBeforeClick = " + actualTitleBeforeClick);


//    5. Click	to:	“Click	Here” text

    WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
    clickHereLink.click();

 for (String eachHandle : driver.getWindowHandles()){
     driver.switchTo().window(eachHandle);
     System.out.println("CURRENT TITLE WHILE SWITCHING: " + driver.getTitle());
   //  if (driver.getTitle().contains("")) just to stop break the loop!
 }

    String actualTitleAfterClick = driver.getTitle();

    System.out.println("actualTitleAfterClick = " + actualTitleAfterClick);



//    6. Switch	to	new	Window.




//    7. Assert:	Title	is	“New	Window”
    }
}
