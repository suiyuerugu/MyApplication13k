package com.example.wxj.myapplication13k;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowInfoActivity extends AppCompatActivity {
    private ImageView showImage;
    private TextView showPrice, showContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);
        showImage=(ImageView)findViewById(R.id.show_image);
        showPrice=(TextView)findViewById(R.id.show_price);
        showContent=(TextView)findViewById(R.id.show_content);

        Intent intent1=getIntent();
        showImage.setImageResource(intent1.getIntExtra("image1",1));
        showPrice.setText(intent1.getStringExtra("price1"));
        showContent.setText(intent1.getStringExtra("content1"));
    }
}
