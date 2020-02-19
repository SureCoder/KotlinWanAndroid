package com.my.kotlinwanandroid.ui.home;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.my.kotlinwanandroid.R;

public class TestActivty extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            int i = 10/0;
            Log.e("test","除法");
        }catch (Exception e){
            e.printStackTrace();
        }
        Log.e("test","1");
    }
}
