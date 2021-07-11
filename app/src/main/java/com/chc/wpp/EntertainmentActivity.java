package com.chc.wpp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class EntertainmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entertainment_navigation);
        Toolbar toolbar = findViewById(R.id.toolBar);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        DrawerLayout drawerLayout = findViewById(R.id.navigation_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.stopen, R.string.stclose);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.yellow));
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    public void openPoetry(View view) {
        Intent i = new Intent(EntertainmentActivity.this,PoetryActivity.class);
        startActivity(i);
    }

    public void openStory(View view) {
        Intent i = new Intent(EntertainmentActivity.this,StoryActivity.class);
        startActivity(i);
    }

    public void openGallery(View view) {
        Intent intent = new Intent(EntertainmentActivity.this,GalleryActivity.class);
        startActivity(intent);
    }
}