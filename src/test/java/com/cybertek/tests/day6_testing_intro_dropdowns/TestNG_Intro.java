package com.cybertek.tests.day6_testing_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Intro {

    @BeforeMethod
    public void setUpClass(){



                System.out.println("--->Before Class is running");


    }
    @AfterMethod
    public void tearDownClass(){
        System.out.println("----------> After class is running");
    }

    @BeforeMethod
    public void setupMethod(){
        System.out.println("-----> Before method is running...");

    }
@AfterMethod
public void teardownMethod(){
    System.out.println("----> After method is running...");
}



    @Test
    public void test1(){
        System.out.println("Running test 1...");

    }
    @Test
    public void test2(){
        System.out.println("running test 2");
        String actual = "apple";
        String expected = "apples";

        Assert.assertEquals(actual,expected);
        System.out.println("Running test 2..");
        Assert.assertTrue(actual.equals(expected));
    }
}
