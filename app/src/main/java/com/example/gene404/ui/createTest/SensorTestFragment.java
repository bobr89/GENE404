package com.example.gene404.ui.createTest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.gene404.R;

public class SensorTestFragment extends Fragment {
    private SensorTestViewModel sensorTestViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sensorTestViewModel =
                ViewModelProviders.of(this).get(SensorTestViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sensor_test, container, false);
        return root;
    }
}
