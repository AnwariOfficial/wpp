package com.chc.wpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsContentActivity extends AppCompatActivity {
    TextView newsTitle;
    TextView newsContent;
    ImageView newsImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);

        newsTitle = findViewById(R.id.newsContainerTitle);
        newsContent = findViewById(R.id.newsContainerContent);
        newsImage = findViewById(R.id.newsContainerImage);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        int image = intent.getIntExtra("image",0);

        newsTitle.setText(title);
        newsContent.setText(content);
        newsImage.setImageResource(image);

    }
}