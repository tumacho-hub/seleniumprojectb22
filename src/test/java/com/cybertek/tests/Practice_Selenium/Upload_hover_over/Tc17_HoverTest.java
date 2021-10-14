package com.cybertek.tests.Practice_Selenium.Upload_hover_over;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
TC #16: Hover Test
1.Go to https://demos.telerik.com/kendo-ui/dragdrop/index
2.Drag and drop the small circle to bigger circle.
3.Assert:
-Text in big circle changed to: “You did great!”
 */
public class Tc17_HoverTest {
    @Test
    public void hoverTest(){
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions = new Actions(Driver.getDriver());

        WebElement smallBall = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));

        BrowserUtils.sleep(2);

        WebElement dropCircle = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));

        actions.dragAndDrop(smallBall,dropCircle).perform();

        WebElement youDidGreat =  Driver.getDriver().findElement(By.xpath("//div[@class='k-header painted']"));

        Assert.assertTrue(youDidGreat.isDisplayed());





    }

}
