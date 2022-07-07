package com.example.practice.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.practice.R;

public class FragmentB extends Fragment {
    private FragmentBListener listener;
    private EditText et2;
    private Button btn1;
    
    public interface FragmentBListener {
        void onInputBSent(CharSequence input);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b, container, false);
        
        et2 = v.findViewById(R.id.etText2);
        btn1 = v.findViewById(R.id.btn2frg);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = et2.getText();
                listener.onInputBSent(input);
            }
        });
        return v;
    }

    public void updateEditText(CharSequence newText){
        et2.setText(newText);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentBListener){
            listener = (FragmentBListener) context;
        }
        else{
            throw new RuntimeException(context.toString()
                    +" must implement FragmentBListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
