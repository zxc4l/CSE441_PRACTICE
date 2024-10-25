package com.example.baith03;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.baith03.R;

public class StudentViewHolder extends RecyclerView.ViewHolder {

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

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewId = itemView.findViewById(R.id.textViewId);
        textViewFullName = itemView.findViewById(R.id.textViewFullName);
        textViewBirthDate = itemView.findViewById(R.id.textViewBirthDate);
        textViewAddress = itemView.findViewById(R.id.textViewAddress);
        textViewEmail = itemView.findViewById(R.id.textViewEmail);
        textViewMajor = itemView.findViewById(R.id.textViewMajor);
        textViewGpa = itemView.findViewById(R.id.textViewGpa);
        textViewYear = itemView.findViewById(R.id.textViewYear);
        textViewGender = itemView.findViewById(R.id.textViewGender);
        buttonBack = itemView.findViewById(R.id.buttonBack);
        buttonEdit = itemView.findViewById(R.id.buttonEdit);
        buttonDelete = itemView.findViewById(R.id.buttonDelete);
    }

    public void bind(com.example.baith03.Student student, View.OnClickListener editClickListener, View.OnClickListener deleteClickListener, View.OnClickListener backClickListener) {
        textViewId.setText(student.getId());
        textViewFullName.setText(student.getFullName());
        textViewBirthDate.setText(student.getBirthDate());
        textViewAddress.setText(student.getAddress());
        textViewEmail.setText(student.getEmail());
        textViewMajor.setText(student.getMajor());
        textViewGpa.setText(String.valueOf(student.getGpa()));
        textViewYear.setText(student.getYear());
        textViewGender.setText(student.getGender());

        buttonEdit.setOnClickListener(editClickListener);
        buttonDelete.setOnClickListener(deleteClickListener);
        buttonBack.setOnClickListener(backClickListener);
    }
}
