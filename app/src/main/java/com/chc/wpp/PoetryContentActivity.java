package com.chc.wpp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.mlkit.nl.languageid.LanguageIdentification;
import com.google.mlkit.nl.languageid.LanguageIdentifier;

public class PoetryContentActivity extends AppCompatActivity {
    PoetryRecyclerAdapter adapter;
    TextView username;
    TextView date;
    TextView cont_poetry;
    TextView cont_author;
    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPref = getSharedPreferences("languagePref", Context.MODE_PRIVATE);
        String defaultValue = getResources().getString(R.string.defautllanguage);
        String language = sharedPref.getString(getString(R.string.language), defaultValue);
        //super.onCreate(savedInstanceState);
        if(language.equals("pashto")){
            setContentView(R.layout.pashto_poertry_content_navigation);
        }else if (language.equals("dari")){
            setContentView(R.layout.dari_poertry_content_navigation);
        }
        else{
            setContentView(R.layout.english_poertry_content_navigation);
        }
        //setContentView(R.layout.activity_poetry_content);
        //setContentView(R.layout.english_poertry_content_navigation);
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        DrawerLayout drawerLayout = findViewById(R.id.navigation_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.stopen, R.string.stclose);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.yellow));
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        Intent intent = getIntent();
        String title = intent.getStringExtra("username");
        String content = intent.getStringExtra("date");
        String poetry = intent.getStringExtra("poetry");
        String author = intent.getStringExtra("author");

        username = findViewById(R.id.username);
        date = findViewById(R.id.date);
        cont_poetry = findViewById(R.id.content_poetry);
        cont_author = findViewById(R.id.content_author);
        LanguageIdentifier languageIdentifier =
                LanguageIdentification.getClient();
        languageIdentifier.identifyLanguage(poetry)
                .addOnSuccessListener(
                        new OnSuccessListener<String>() {
                            @Override
                            public void onSuccess(String languageCode) {
                                if (languageCode.equals("ps") || languageCode.equals("fa")) {
                                    cont_poetry.setTextDirection(View.TEXT_DIRECTION_RTL);
                                    cont_poetry.setTextDirection(View.LAYOUT_DIRECTION_RTL);
                                    cont_poetry.setPadding(0,0,8,0);

                                } else if(languageCode.equals("en")) {
                                    cont_poetry.setTextDirection(View.TEXT_DIRECTION_LTR);
                                    cont_poetry.setTextDirection(View.LAYOUT_DIRECTION_LTR);
                                    cont_poetry.setPadding(8,0,0,0);

                                }
                            }
                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure( Exception e) {
                                System.out.println("Failure Listiner");
                            }
                        });
        username.setText(title);
        date.setText(content);
        cont_poetry.setText(poetry);
        cont_author.setText(author);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.home){
                    Intent intent = new Intent(PoetryContentActivity.this,NewsActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.idea){
                    Intent intent = new Intent(PoetryContentActivity.this,IdeasActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.entertainment){
                    Intent intent = new Intent(PoetryContentActivity.this,EntertainmentActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.about){
                    Intent intent = new Intent(PoetryContentActivity.this,AboutActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.logout){
                    Intent intent = new Intent(PoetryContentActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


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

}
