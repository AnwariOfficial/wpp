package com.chc.wpp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.nl.languageid.LanguageIdentification;
import com.google.mlkit.nl.languageid.LanguageIdentifier;

public class BlogsContentActivity extends AppCompatActivity {
    TextView newsTitle;
    TextView newsContent;
    ImageView newsImage;
    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPref = getSharedPreferences("languagePref", Context.MODE_PRIVATE);
        String defaultValue = getResources().getString(R.string.defautllanguage);
        String language = sharedPref.getString(getString(R.string.language), defaultValue);
        //super.onCreate(savedInstanceState);
        if(language.equals("pashto")){
            setContentView(R.layout.pashto_activity_news_content);
        }else if (language.equals("dari")){
            setContentView(R.layout.dari_activity_news_content);
        }
        else{
            setContentView(R.layout.english_activity_blogs_content);
        }
       // setContentView(R.layout.english_activity_news_content);

        newsTitle = findViewById(R.id.newsContainerTitle);
        newsContent = findViewById(R.id.newsContainerContent);
        newsImage = findViewById(R.id.newsContainerImage);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        int image = intent.getIntExtra("image",0);

        LanguageIdentifier languageIdentifier =
                LanguageIdentification.getClient();
        languageIdentifier.identifyLanguage(content)
                .addOnSuccessListener(
                        new OnSuccessListener<String>() {
                            @Override
                            public void onSuccess(String languageCode) {
                                if (languageCode.equals("ps") || languageCode.equals("fa")) {
                                    newsTitle.setTextDirection(View.TEXT_DIRECTION_RTL);
                                    newsTitle.setTextDirection(View.LAYOUT_DIRECTION_RTL);
                                    newsContent.setTextDirection(View.LAYOUT_DIRECTION_RTL);
                                    newsContent.setTextDirection(View.TEXT_DIRECTION_RTL);
                                    newsTitle.setPadding(8,0,8,0);
                                    newsContent.setPadding(0,0,10,0);
                                } else if(languageCode.equals("en")) {
                                    newsTitle.setTextDirection(View.TEXT_DIRECTION_LTR);
                                    newsTitle.setTextDirection(View.LAYOUT_DIRECTION_LTR);
                                    newsContent.setTextDirection(View.LAYOUT_DIRECTION_LTR);
                                    newsContent.setTextDirection(View.TEXT_DIRECTION_LTR);
                                    newsTitle.setPadding(8,0,8,0);
                                    newsContent.setPadding(8,0,0,0);
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

        newsTitle.setText(title);
        newsContent.setText(content);
        newsImage.setImageResource(image);

    }
}