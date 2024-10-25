package com.example.prac02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private StaffViewModel staffViewModel;
    private TextView txtResult;
    private EditText edtStaffId, edtFullName, edtBirthDate, edtSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        staffViewModel = new ViewModelProvider(this).get(StaffViewModel.class);

        txtResult = findViewById(R.id.txt_result);
        edtStaffId = findViewById(R.id.edt_staff_id);
        edtFullName = findViewById(R.id.edt_full_name);
        edtBirthDate = findViewById(R.id.edt_birth_date);
        edtSalary = findViewById(R.id.edt_salary);
        Button btnAddStaff = findViewById(R.id.btn_add_staff);

        staffViewModel.getStaffList().observe(this, staffList -> {
            if (staffList.isEmpty()) {
                txtResult.setText("No Result!");
            } else {
                StringBuilder result = new StringBuilder();
                for (Staff staff : staffList) {
                    result.append(staff.getStaffId()).append(" - ")
                            .append(staff.getFullName()).append(" - ")
                            .append(staff.getBirthDate()).append(" - ")
                            .append(staff.getSalary()).append("\n");
                }
                txtResult.setText(result.toString());
            }
        });

        btnAddStaff.setOnClickListener(v -> {
            String staffId = edtStaffId.getText().toString();
            String fullName = edtFullName.getText().toString();
            String birthDate = edtBirthDate.getText().toString();
            int salary = Integer.parseInt(edtSalary.getText().toString());

            Staff newStaff = new Staff(staffId, fullName, birthDate, salary);
            staffViewModel.addStaff(newStaff);
        });
    }
}
