package com.example.zyy19.myapplication4;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;


public class Pop extends Activity{
    @Override
    protected void onCreate(Bundle saveInstantState){
        super.onCreate(saveInstantState);

        setContentView(R.layout.popwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));
    }
    //pop up the window
}
