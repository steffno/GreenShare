package com.rusthell.greenshare;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class DashboardFragment extends Fragment {

    private ConstraintLayout dataContainer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        dataContainer = (ConstraintLayout) view.findViewById(R.id.data_container);

        for(int i = 0; i<10; i++){
            container.addView(dataContainer);\
            /*
            Leggi qui https://stackoverflow.com/questions/65297495/how-to-create-programmatically-cardview
             */
        }

        return view;
    }
}