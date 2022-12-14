package com.example.minicrm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.minicrm.activity.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}