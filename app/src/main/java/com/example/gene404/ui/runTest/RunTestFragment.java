package com.example.gene404.ui.runTest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.gene404.R;

public class RunTestFragment extends Fragment {

    private RunTestViewModel runTestViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        runTestViewModel =
                ViewModelProviders.of(this).get(RunTestViewModel.class);
        View root = inflater.inflate(R.layout.fragment_run_test, container, false);
//        final TextView textView = root.findViewById(R.id.text_gallery);
//        runTestViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}