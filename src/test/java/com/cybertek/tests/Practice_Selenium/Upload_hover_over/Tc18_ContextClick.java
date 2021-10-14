package com.cybertek.tests.Practice_Selenium.Upload_hover_over;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/*
TC #17: Context Click –HOMEWORK
1.Go to https://the-internet.herokuapp.com/context_menu
2.Right click to the box.
3.Alert will open.
4.Accept alertNo assertion needed for this practice.
 */
public class Tc18_ContextClick {

    @Test
    public void contextClick(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(Driver.getDriver());

        WebElement squareBox = Driver.getDriver().findElement(By.xpath("//div[@id='hot-spot']"));

        actions.contextClick(squareBox).perform();

        BrowserUtils.sleep(1);
        Alert alert = Driver.getDriver().switchTo().alert();

        alert.accept();



    }


}
