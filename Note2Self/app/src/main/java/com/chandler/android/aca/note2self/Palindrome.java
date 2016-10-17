package com.chandler.android.aca.note2self;

import android.app.Activity;
import android.os.Bundle;

public class Palindrome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String pal = "civic";

        int length = pal.length();

        for (int i = 0; i < (length / 2); ++i){
            if(pal.charAt(i) != pal.charAt(length - i - 1)) {
                System.out.println("Sorry, no");
            } else {
                System.out.println("That's a palindrome");
            }
        }


        /*
        if(isPalindrome(pal)){
            System.out.println("This is a pal");
        }else{System.out.println("This is not a pal");
        */
    }


    public boolean isPalindrome(String string) {
        int length = string.length();
        for (int i = 0; i < (length / 2); ++i) {
            if (string.charAt(i) != string.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
