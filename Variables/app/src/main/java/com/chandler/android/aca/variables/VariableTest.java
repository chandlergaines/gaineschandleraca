package com.chandler.android.aca.variables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class VariableTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variable_test);

        boolean booleanVar = true;
        int intVar = 2_000_000_000;
        float floatVar = 1.0f; //needs to be closed with f
        double doubleVar = 1.00001;
        char charVar = 'a'; //needs single quotes
        byte byteVar = -128;
        short shortVar = 30_000;
        long longVar = 9_000_000_000_000_000_000L; //needs to be closed with L

        System.out.println("Boolean Variable: " + booleanVar);
        System.out.println("Integer Variable: " + intVar);
        System.out.println("Float Variable: " + floatVar);
        System.out.println("Double Variable: " + doubleVar);
        System.out.println("Character Variable: " + charVar);
        System.out.println("Byte Variable: " + byteVar);
        System.out.println("Short Variable: " + shortVar);
        System.out.println("Long Variable: " + longVar);
    }
}
