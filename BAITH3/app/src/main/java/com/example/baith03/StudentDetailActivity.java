package com.example.baith03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StudentDetailActivity extends AppCompatActivity {

    private TextView textViewId;
    private TextView textViewFullName;
    private TextView textViewBirthDate;
    private TextView textViewAddress;
    private TextView textViewEmail;
    private TextView textViewMajor;
    private TextView textViewGpa;
    private TextView textViewYear;
    private TextView textViewGender;
    private ImageView buttonBack;
    private ImageView buttonEdit;
    private ImageView buttonDelete;
    private com.example.baith03.Student student;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        textViewId = findViewById(R.id.textViewId);
        textViewFullName = findViewById(R.id.textViewFullName);
        textViewBirthDate = findViewById(R.id.textViewBirthDate);
        textViewAddress = findViewById(R.id.textViewAddress);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewMajor = findViewById(R.id.textViewMajor);
        textViewGpa = findViewById(R.id.textViewGpa);
        textViewYear = findViewById(R.id.textViewYear);
        textViewGender = findViewById(R.id.textViewGender);
        buttonBack = findViewById(R.id.buttonBack);
        buttonEdit = findViewById(R.id.buttonEdit);
        buttonDelete = findViewById(R.id.buttonDelete);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("student")) {
            student = (com.example.baith03.Student) intent.getSerializableExtra("student");
            displayStudentDetails();
        }

        // Thiết lập các listener cho các nút
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Trở về activity trước đó
            }
        });

        // Kích hoạt nút chỉnh sửa nếu cần
//        buttonEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Mở activity chỉnh sửa sinh viên
//                Intent editIntent = new Intent(StudentDetailActivity.this, EditStudentActivity.class);
//                editIntent.putExtra("student", student);
//                startActivity(editIntent);
//            }
//        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteStudent();
            }
        });
    }

    private void displayStudentDetails() {
        if (student != null) {
            textViewId.setText(student.getId());
            textViewFullName.setText(student.getFullName()); // Chỉ gọi getter cho fullName
            textViewBirthDate.setText(student.getBirthDate());
            textViewAddress.setText(student.getAddress());
            textViewEmail.setText(student.getEmail());
            textViewMajor.setText(student.getMajor());
            textViewGpa.setText(String.valueOf(student.getGpa()));
            textViewYear.setText(String.valueOf(student.getYear()));
            textViewGender.setText(student.getGender());
        }
    }


    private void deleteStudent() {

        Toast.makeText(this, "Sinh viên đã được xóa!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
