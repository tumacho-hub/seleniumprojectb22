package com.cybertek.tests.Practice_Selenium.Upload_hover_over;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
TC #16: Double ClickTest
1.Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
2.Switch to iframe.
3.Double click on the text “Double-click me to change my text color.”
4.Assert: Text’s “style” attribute value contains “red”.
 */
public class Tc16_DoubleClickTest {

    @Test
    public void doubleClick(){
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        WebElement iframe = Driver.getDriver().findElement(By.name("iframeResult"));
        Driver.getDriver().switchTo().frame(iframe);

        WebElement clickClick = Driver.getDriver().findElement(By.xpath("//p[@id='demo']"));

        Actions actions = new Actions(Driver.getDriver());

        actions.doubleClick(clickClick).perform();

        WebElement getcolor = Driver.getDriver().findElement(By.xpath("//p[@style='color: red;']"));

        Assert.assertTrue(getcolor.isDisplayed());

    }



}

