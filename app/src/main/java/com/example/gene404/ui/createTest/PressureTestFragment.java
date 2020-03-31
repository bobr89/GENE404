package com.example.gene404.ui.createTest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.gene404.R;

public class PressureTestFragment extends Fragment {
    private PressureTestViewModel pressureTestViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pressureTestViewModel =
                ViewModelProviders.of(this).get(PressureTestViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pressure_test, container, false);
        return root;
    }
}
