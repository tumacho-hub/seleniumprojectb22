package com.cybertek.tests.day10_Webtable_Practices;

import com.cybertek.utilities.Driver;
import org.testng.annotations.Test;

public class driverusingexample {
    @Test
    public void hot_to_Use_driver(){

        Driver.getDriver().get("http://practice.cybertekschool.com/tables#edit");
    }
}
