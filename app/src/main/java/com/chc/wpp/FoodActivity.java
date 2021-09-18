package com.chc.wpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.english_activity_food);
    }
    public void openFood(View view) {
        Intent intent = new Intent(FoodActivity.this,CultureActivity.class);
        startActivity(intent);
    }

    public void openAttan(View view) {
        Intent intent = new Intent(FoodActivity.this, FoodActivity.class);
        startActivity(intent);
    }

    public void openColthes(View view) {
        Intent intent = new Intent(FoodActivity.this, AttanActivity.class);
        startActivity(intent);
    }
}