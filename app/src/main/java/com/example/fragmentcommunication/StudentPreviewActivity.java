package com.example.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class StudentPreviewActivity extends AppCompatActivity {
    private TextView tvnamee;
    private TextView tvage;
    private TextView tvgrade;
    private TextView tvpercent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_preview);
        initviews();
        getdata();
    }

    private void getdata() {
        Model model= (Model) getIntent().getSerializableExtra("model");
        tvnamee.setText(model.getName());
        tvage.setText(model.getAge()+"");
        tvgrade.setText(model.getGrade());
        tvpercent.setText(model.getPercentage());
    }

    private void initviews() {
        tvnamee=findViewById(R.id.tvStudentName);
        tvage=findViewById(R.id.tvStudentAge);
        tvgrade=findViewById(R.id.tvStudentGrade);
        tvpercent=findViewById(R.id.tvStudentPercentage);
    }
}