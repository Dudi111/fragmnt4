package com.example.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements communicationlistener {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();
        launchstudentdetailfragment();
    }

    private void launchstudentdetailfragment() {

        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        StudentDetailFragment studentDetailFragment=new StudentDetailFragment();

        fragmentTransaction.add(R.id.container,studentDetailFragment,"StudentFragment").commit();


    }

    @Override
    public void launchperformencelistener(Bundle bundle) {
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        PerformenceFragment performenceFragment=new PerformenceFragment();
        performenceFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.container,performenceFragment,"PerformenceFragment").addToBackStack("").commit();


    }
}