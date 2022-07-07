package com.example.practice.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practice.R;

public class fragment_main extends AppCompatActivity implements  FragmentA.FragmentAListener, FragmentB.FragmentBListener{
    private FragmentA fragmentA;
    private FragmentB fragmentB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        fragmentA = new FragmentA();
        fragmentB = new FragmentB();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayout1,fragmentA)
                .replace(R.id.framelayout2,fragmentB)
                .commit();
    }

    @Override
    public void onInputASent(CharSequence input) {
        fragmentB.updateEditText(input);
    }

    @Override
    public void onInputBSent(CharSequence input) {
        fragmentA.updateEditText(input);
    }
}
