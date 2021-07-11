package com.chc.wpp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class IdeasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ideas_navigation);
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        DrawerLayout drawerLayout = findViewById(R.id.navigation_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.stopen, R.string.stclose);
       actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.yellow));
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
                if(item.getItemId() == R.id.home){
                    Intent intent = new Intent(IdeasActivity.this,NewsActivity.class);
                    startActivity(intent);
                }else if(item.getItemId() == R.id.idea){
                    Intent intent = new Intent(IdeasActivity.this,IdeasActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.entertainment){
                    Intent intent = new Intent(IdeasActivity.this,EntertainmentActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.about){
                    Intent intent = new Intent(IdeasActivity.this,AboutActivity.class);
                    startActivity(intent);
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    public void openNews(View view) {
        Intent i = new Intent(IdeasActivity.this,NewsActivity.class);
        startActivity(i);
    }

    public void openRecentIdeas(View view) {
        Intent intent = new Intent(IdeasActivity.this,RecentPostsActivity.class);
        startActivity(intent);
    }
}