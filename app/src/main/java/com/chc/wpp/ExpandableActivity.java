package com.chc.wpp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ExpandableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandable_fab);
    }
}