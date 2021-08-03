package com.example.fragmentcommunication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class PerformenceFragment extends Fragment {
    private EditText etgrade;
    private EditText etpercent;
    private Button mbtnpreview;
    private String name;
    private  int age;


    @Override
    public void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            name=getArguments().getString("name");
            age=getArguments().getInt("age");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_performence, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         inittview(view);
    }

    private void inittview(View view) {
        etgrade=view.findViewById(R.id.etStudentgrade);
        etpercent=view.findViewById(R.id.etStudentpercentage);
        mbtnpreview=view.findViewById(R.id.btnPreview);
        mbtnpreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String grade=etgrade.getText().toString();
                String percent=etpercent.getText().toString();
                Model model=new Model(name,grade,age,percent);
                Intent intent=new Intent(getActivity(),StudentPreviewActivity.class);
                intent.putExtra("model", model);
                startActivity(intent);

            }
        });
    }
}