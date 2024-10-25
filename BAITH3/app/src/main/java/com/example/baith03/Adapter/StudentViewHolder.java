package com.example.baith03.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.baith03.R;
import com.example.baith03.Student;
import com.example.baith03.StudentDetailActivity;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    private TextView textViewName;
    private TextView textViewId;
    private TextView textViewGpa;

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewName = itemView.findViewById(R.id.textViewName);
        textViewId = itemView.findViewById(R.id.textViewId);
        textViewGpa = itemView.findViewById(R.id.textViewGpa);
    }

    public void bind(Student student, Context context) {

        textViewName.setText(student.getFullName());

        textViewId.setText(student.getId());

        textViewGpa.setText(String.valueOf(student.getGpa()));


        itemView.setOnClickListener(v -> {
            // Mở StudentDetailActivity và truyền thông tin sinh viên
            Intent intent = new Intent(context, StudentDetailActivity.class);
            intent.putExtra("student", student);
            context.startActivity(intent);
        });
    }
}
