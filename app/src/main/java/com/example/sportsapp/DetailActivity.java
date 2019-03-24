package com.example.sportsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    TextView tvDetail;
    ImageView imgDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDetail = findViewById(R.id.tv_detail);
        imgDetail = findViewById(R.id.img_detail);

        tvDetail.setText(getIntent().getStringExtra("a"));
        Picasso.get().load(getIntent().getStringExtra("b")).into(imgDetail);

    }
}
