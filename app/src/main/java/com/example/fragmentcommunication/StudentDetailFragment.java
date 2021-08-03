package com.example.fragmentcommunication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class StudentDetailFragment extends Fragment {
    private Button mbtnnext;
    private EditText etname;
    private EditText etage;
    private communicationlistener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false);

    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview(view);
    }

    @Override
    public void onAttach(@NonNull  Context context) {
        super.onAttach(context);
        listener= (communicationlistener) context;
    }

    private void initview(View view) {
        etname=view.findViewById(R.id.etStudentName);
        etage=view.findViewById(R.id.etStudentAge);
        mbtnnext=view.findViewById(R.id.btnNext);
        mbtnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etname.getText().toString();
                int age= Integer.parseInt(etage.getText().toString());
                Bundle bundle=new Bundle();
                bundle.putString("name",name);
                bundle.putInt("age",age);
                 if(listener!=null){
                     listener.launchperformencelistener(bundle);
                 }
            }
        });

    }
}