package com.example.prac01;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private TextView txt_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_name = findViewById(R.id.txt_name);
        Button openChildActivityButton = findViewById(R.id.btn_start);

        openChildActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChildActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String fullName = data.getStringExtra("fullName");
            float gpa = data.getFloatExtra("gpa", 0.0f);

            txt_name.setText("Họ và tên: " + fullName + "\nĐiểm trung bình tích lũy: " + gpa);
        }
    }
}
