package com.example.prac01;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChildActivity extends AppCompatActivity {

    private EditText edt_name;
    private EditText edt_gpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        edt_name = findViewById(R.id.edt_name);
        edt_gpa = findViewById(R.id.edt_gpa);
        Button returnDataButton = findViewById(R.id.btn_submit);

        returnDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = edt_name.getText().toString();
                float gpa = Float.parseFloat(edt_gpa.getText().toString());

                Intent returnIntent = new Intent();
                returnIntent.putExtra("fullName", fullName);
                returnIntent.putExtra("gpa", gpa);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
