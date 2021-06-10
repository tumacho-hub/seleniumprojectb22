package com.cybertek.tests.day9_properties_browser_utils;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {
    @Test
    public void reading_from_Properties_file() throws IOException {
        //#1 create Object of Properties class(coming from java library)
        Properties properties = new Properties();

        //#2 open the file using  FileInputStream
        FileInputStream file = new FileInputStream("configuration.properties");

        //#3 Load the properties objects with our file
        properties.load(file);

        // reading from configuration.properties
        properties.getProperty("browser");

        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));

        properties.getProperty("env");
        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));



    }

    @Test
    public void using_properties_method(){
        System.out.println("ConfigurationReader.getProperty(\"browser\") = " + ConfigurationReader.getProperty("browser"));
        System.out.println("ConfigurationReader.getProperty(\"env\") = " + ConfigurationReader.getProperty("env"));
    }
}
