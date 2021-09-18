package com.chc.wpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AttanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.english_activity_attan);
    }
    public void openFood(View view) {
        Intent intent = new Intent(AttanActivity.this,CultureActivity.class);
        startActivity(intent);
    }

    public void openAttan(View view) {
        Intent intent = new Intent(AttanActivity.this, FoodActivity.class);
        startActivity(intent);
    }

    public void openColthes(View view) {
        Intent intent = new Intent(AttanActivity.this, AttanActivity.class);
        startActivity(intent);
    }
}