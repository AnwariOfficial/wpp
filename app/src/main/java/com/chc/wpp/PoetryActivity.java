package com.chc.wpp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PoetryActivity extends AppCompatActivity {
    PoetryRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poetry_navigation);
        Toolbar toolbar = findViewById(R.id.toolBar);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        DrawerLayout drawerLayout = findViewById(R.id.navigation_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.stopen, R.string.stclose);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.yellow));
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        List<Poetry> newsList = new ArrayList<>();

        Poetry poetry = new Poetry();
        poetry.setUserName("Najibullah Anwari");
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String strDate = dateFormat.format(date);
        poetry.setPostDate(date);

        poetry.setIdeaPost(getResources().getString(R.string.lgContentNews));

        Poetry poetry1 = new Poetry();
        poetry1.setUserName("Najibullah Anwari");
         date = Calendar.getInstance().getTime();
         dateFormat = new SimpleDateFormat("yyyy-mm-dd");
         strDate = dateFormat.format(date);
        poetry1.setPostDate(date);
        poetry1.setIdeaPost(getResources().getString(R.string.lgContentNews));

        Poetry poetry2 = new Poetry();
        poetry2.setUserName("Najibullah Anwari");
        date = Calendar.getInstance().getTime();
        dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        strDate = dateFormat.format(date);
        poetry2.setPostDate(date);
        poetry2.setIdeaPost(getResources().getString(R.string.lgContentNews));

        Poetry poetry3 = new Poetry();
        poetry3.setUserName("Najibullah Anwari");
        date = Calendar.getInstance().getTime();
        dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        strDate = dateFormat.format(date);
        poetry3.setPostDate(date);
        poetry.setIdeaPost(getResources().getString(R.string.lgContentNews));

        newsList.add(poetry);
        newsList.add(poetry1);
        newsList.add(poetry1);
        newsList.add(poetry1);
        newsList.add(poetry2);
        newsList.add(poetry2);
        newsList.add(poetry2);
        newsList.add(poetry3);
        newsList.add(poetry3);
        newsList.add(poetry3);

        RecyclerView recyclerView = findViewById(R.id.poetryRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(PoetryActivity.this,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator( new DefaultItemAnimator());


        adapter = new PoetryRecyclerAdapter(this, newsList);
        recyclerView.setAdapter(adapter);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.home){
                    Intent intent = new Intent(PoetryActivity.this,NewsActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.idea){
                    Intent intent = new Intent(PoetryActivity.this,IdeasActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.entertainment){
                    Intent intent = new Intent(PoetryActivity.this,EntertainmentActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.about){
                    Intent intent = new Intent(PoetryActivity.this,AboutActivity.class);
                    startActivity(intent);
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}