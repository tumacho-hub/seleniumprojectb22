package com.cybertek.tests.day9_properties_browser_utils;

import org.testng.annotations.Test;

public class LearninProperties {
    @Test
    public void java_properties_reading_test(){

        System.out.println("System.clearProperty(\"os.name\") = " + System.clearProperty("os.name"));
        System.out.println(System.getProperty("user.name"));
    }
}
