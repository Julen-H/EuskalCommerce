package com.talde1.commerceapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static int userId;
    //Colores para app.
    //#27187E , #758BFD , #AEB8FE , #F1F2F6 , #FF8600
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static int getUserId() {
        return MainActivity.userId;
    }

    public static void setUserId(int userId) {
        MainActivity.userId = userId;
    }
}