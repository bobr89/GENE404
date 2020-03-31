package com.example.gene404.ui.createTest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.gene404.R;

public class ConnectionTestFragment extends Fragment {
    private ConnectionTestViewModel connectionTestViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        connectionTestViewModel =
                ViewModelProviders.of(this).get(ConnectionTestViewModel.class);
        View root = inflater.inflate(R.layout.fragment_connection_test, container, false);
        return root;
    }
}
