package com.chc.wpp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;


public class NewsActivity extends AppCompatActivity implements NewsRecyclerAdapter.ItemClickListener{

    NewsRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_news);
        setContentView(R.layout.navigation_layout);
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
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.home){
                    Intent intent = new Intent(NewsActivity.this,NewsActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.idea){
                    Intent intent = new Intent(NewsActivity.this,IdeasActivity.class);
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
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });



        // data to populate the RecyclerView with
        ArrayList<News> animalNames = new ArrayList<>();
        News n1 = new News();
        n1.setNews_content(getResources().getString(R.string.lgContentNews));
        n1.setNews_image(R.drawable.news_image);
        n1.setNews_title("Afghanistan is developed country");

        News n2 = new News();
        n2.setNews_content(getResources().getString(R.string.lgContentNews));
        n2.setNews_image(R.drawable.news_image);
        n2.setNews_title("Afghanistan is developed country");
        News n3 = new News();
        n3.setNews_content("Video provides a powerful way to help you prove your point. When you click Online Video, you can paste in the embed code for the video you want to add.\n" +
                "        You can also type a keyword to search online for the video that best fits your document. Video provides a powerful way to help you prove your point. When you click Online Video, you can paste in the embed code for the video you want to add. You can also type a keyword to search online for the video that best fits your document.");
        n3.setNews_image(R.drawable.anwari);
        n3.setNews_title("Afghanistan is developed country");
        News n4 = new News();
        n4.setNews_content("Video provides a powerful way to help you prove your point. When you click Online Video, you can paste in the embed code for the video you want to add.\n" +
                "        You can also type a keyword to search online for the video that best fits your document. Video provides a powerful way to help you prove your point. When you click Online Video, you can paste in the embed code for the video you want to add. You can also type a keyword to search online for the video that best fits your document.");
        n4.setNews_image(R.drawable.anwari);
        n4.setNews_title("Afghanistan is developed country");

        List<News> newsList = new ArrayList<>();
        newsList.add(n1);
        newsList.add(n2);
        newsList.add(n3);
        newsList.add(n4);


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


}