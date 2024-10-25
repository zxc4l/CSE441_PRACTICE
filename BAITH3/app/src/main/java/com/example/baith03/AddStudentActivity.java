package com.example.baith03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baith03.R;

public class AddStudentActivity extends AppCompatActivity {

    private EditText editTextId, editTextFullName, editTextBirthDate, editTextAddress, editTextEmail, editTextMajor, editTextYear;
    private SeekBar seekBarGpa;
    private TextView textViewGpa;
    private RadioGroup radioGroupGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        editTextId = findViewById(R.id.editTextId);
        editTextFullName = findViewById(R.id.editTextFullName);
        editTextBirthDate = findViewById(R.id.editTextBirthDate);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextMajor = findViewById(R.id.editTextMajor);
        editTextYear = findViewById(R.id.editTextYear);
        seekBarGpa = findViewById(R.id.seekBarGpa);
        textViewGpa = findViewById(R.id.textViewGpa);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        Button buttonSave = findViewById(R.id.buttonSave);

        seekBarGpa.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double gpa = progress / 10.0;
                textViewGpa.setText(String.format("%.1f", gpa));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

//
//        buttonSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                saveStudent();
//            }
//        });
    }

    private void saveStudent() {

        String id = editTextId.getText().toString();
        String fullName = editTextFullName.getText().toString();
        String birthDate = editTextBirthDate.getText().toString();
        String address = editTextAddress.getText().toString();
        String email = editTextEmail.getText().toString();
        String major = editTextMajor.getText().toString();
        double gpa = seekBarGpa.getProgress() / 10.0;
        String year = editTextYear.getText().toString();
        int selectedId = radioGroupGender.getCheckedRadioButtonId();
        String gender = "";

        if (selectedId == R.id.radioButtonMale) {
            gender = "Nam";
        } else if (selectedId == R.id.radioButtonFemale) {
            gender = "Nữ";
        } else if (selectedId == R.id.radioButtonOther) {
            gender = "Khác";
        }


        if (id.isEmpty() || fullName.isEmpty() || birthDate.isEmpty() || address.isEmpty() || email.isEmpty() || major.isEmpty() || year.isEmpty()) {
            Toast.makeText(this, "Vui lòng điền tất cả thông tin", Toast.LENGTH_SHORT).show();
            return;
        }


        Toast.makeText(this, "Sinh viên đã được thêm!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
