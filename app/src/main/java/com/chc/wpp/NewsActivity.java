package com.chc.wpp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.mlkit.nl.languageid.LanguageIdentification;
import com.google.mlkit.nl.languageid.LanguageIdentifier;

import java.util.ArrayList;
import java.util.List;


public class NewsActivity extends AppCompatActivity implements NewsRecyclerAdapter.ItemClickListener{
    SharedPreferences sharedPref;
    NewsRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_news);
        sharedPref = getSharedPreferences("languagePref", Context.MODE_PRIVATE);
        String defaultValue = getResources().getString(R.string.defautllanguage);
        String language = sharedPref.getString(getString(R.string.language), defaultValue);
        //super.onCreate(savedInstanceState);
        if(language.equals("pashto")){
            setContentView(R.layout.pashto_navigation_layout);
        }else if (language.equals("dari")){
            setContentView(R.layout.dari_navigation_layout);
        }
        else{
            setContentView(R.layout.english_navigation_layout);
        }
        //setContentView(R.layout.english_navigation_layout);
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        DrawerLayout drawerLayout = findViewById(R.id.navigation_layout);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.stopen, R.string.stclose);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.yellow));
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.home){
                    Intent intent = new Intent(NewsActivity.this,NewsActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.idea){
                    Intent intent = new Intent(NewsActivity.this,IdeasActivity.class);
                    intent.putExtra("flag",true);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.entertainment){
                    Intent intent = new Intent(NewsActivity.this,EntertainmentActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.about){
                    Intent intent = new Intent(NewsActivity.this,AboutActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.survey){
                    Intent intent = new Intent(NewsActivity.this,SurveysActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.logout){
                    Intent intent = new Intent(NewsActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


        // data to populate the RecyclerView with
        ArrayList<News> animalNames = new ArrayList<>();
        News n1 = new News();
        n1.setNews_content(getResources().getString(R.string.news1));
        n1.setNews_image(R.drawable.image1);
        n1.setNews_title(getResources().getString(R.string.heading1));

        News n2 = new News();
        n2.setNews_content(getResources().getString(R.string.news2));
        n2.setNews_image(R.drawable.image2);
        n2.setNews_title(getResources().getString(R.string.heading2));
        News n3 = new News();
        n3.setNews_content(getResources().getString(R.string.news3));
        n3.setNews_image(R.drawable.image3);
        n3.setNews_title(getResources().getString(R.string.heading3));
        News n4 = new News();
        n4.setNews_content(getResources().getString(R.string.news4));
        n4.setNews_image(R.drawable.image4);
        n4.setNews_title(getResources().getString(R.string.heading4));

        News n5 = new News();
        n5.setNews_content(getResources().getString(R.string.news5));
        n5.setNews_image(R.drawable.image5);
        n5.setNews_title(getResources().getString(R.string.heading5));
        List<News> newsList = new ArrayList<>();
        newsList.add(n1);
        newsList.add(n2);
        newsList.add(n3);
        newsList.add(n4);
        newsList.add(n5);

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvAnimals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NewsRecyclerAdapter(this, newsList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

        @Override
        public void onItemClick(View view, int position) {
            Intent intent = new Intent(NewsActivity.this,NewsContentActivity.class);
            News news = adapter.getItem(position);
            intent.putExtra("title",news.getNews_title());
            intent.putExtra("image",news.getNews_image());
            intent.putExtra("content",news.getNews_content());
            startActivity(intent);
           // Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        sharedPref = getSharedPreferences("languagePref",Context.MODE_PRIVATE);
        String defaultValue = getResources().getString(R.string.defautllanguage);
        String language = sharedPref.getString(getString(R.string.language), defaultValue);
        if(language.equals("pashto")){
            getMenuInflater().inflate(R.menu.p_back_menu, menu);
        }else if (language.equals("dari")){
            getMenuInflater().inflate(R.menu.p_back_menu, menu);
        }
        else{
            getMenuInflater().inflate(R.menu.back_menu, menu);
        }

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_back:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void openBlogs(View view) {
        Intent intent = new Intent(NewsActivity.this,BlogsActivity.class);
        startActivity(intent);
    }
    public void openProfileActivity(View view) {
        Intent intent = new Intent(NewsActivity.this,ProfileActivity.class);
        startActivity(intent);
    }
}