package com.chc.wpp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RecentPostsActivity extends AppCompatActivity {
    IdeaRecyclerAdapter adapter;
    Date date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recent_post_navigation);
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        DrawerLayout drawerLayout = findViewById(R.id.navigation_layout);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.stopen, R.string.stclose);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.yellow));
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        List<Idea> newsList = new ArrayList<>();

        Idea idea1 = new Idea();
        idea1.setProfilePhoto(R.drawable.anwari);
        idea1.setUserName("Najibullah Anwari");
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        idea1.setPostDate(date);

        idea1.setIdeaPost(getResources().getString(R.string.lgContentNews));

        Idea idea2 = new Idea();
        idea2.setProfilePhoto(R.drawable.news_image);
        idea2.setUserName("Rafiullah  Omar");
         date = Calendar.getInstance().getTime();
         dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
         strDate = dateFormat.format(date);
        idea2.setPostDate(date);
        idea2.setIdeaPost(getResources().getString(R.string.news_content));

        Idea idea3 = new Idea();
        idea3.setProfilePhoto(R.drawable.anwari);
        idea3.setUserName("Noor Ahmad Ahmadzai");
         date = Calendar.getInstance().getTime();
         dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
         strDate = dateFormat.format(date);
        idea3.setPostDate(date);
        idea3.setIdeaPost(getResources().getString(R.string.lgContentNews));
        newsList.add(idea1);
        newsList.add(idea2);
        newsList.add(idea3);
        newsList.add(idea1);

        RecyclerView recyclerView = findViewById(R.id.recentIdeasRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new IdeaRecyclerAdapter(this, newsList);
        recyclerView.setAdapter(adapter);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.home){
                    Intent intent = new Intent(RecentPostsActivity.this,NewsActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.idea){
                    Intent intent = new Intent(RecentPostsActivity.this,IdeasActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.entertainment){
                    Intent intent = new Intent(RecentPostsActivity.this,EntertainmentActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.about){
                    Intent intent = new Intent(RecentPostsActivity.this,AboutActivity.class);
                    startActivity(intent);
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }


}