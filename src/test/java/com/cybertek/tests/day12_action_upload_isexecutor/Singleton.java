package com.cybertek.tests.day12_action_upload_isexecutor;
/*
  we will create similar logic we created in driver utility class.
  but it will be for a string
   */
public class Singleton {

    // create private constructor

    private Singleton(){}

        // by making the String word private
        // we will ensure we create access only through our getter method



  public static String word;

    // we aloud user to access to word in the way we want them to have
    public static String getWord(){

        if (word==null){
            System.out.println("First time call. Word object is null." +
                    "Assigning value to it now");
            word = "something";
        }else {
            System.out.println("Word already has a value");
        }
        return word;

  }
}
