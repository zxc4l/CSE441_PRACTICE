package com.example.prac03;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageFlagDetail;
    private TextView textCountryNameDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageFlagDetail = findViewById(R.id.imageFlagDetail);
        textCountryNameDetail = findViewById(R.id.textCountryNameDetail);

        String countryName = getIntent().getStringExtra("countryName");
        int flagResource = getIntent().getIntExtra("flagResource", 0);

        textCountryNameDetail.setText(countryName);
        imageFlagDetail.setImageResource(flagResource);
    }
}
