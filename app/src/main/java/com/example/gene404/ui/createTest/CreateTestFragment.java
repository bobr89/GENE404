package com.example.gene404.ui.createTest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.gene404.R;

public class CreateTestFragment extends Fragment {

    private CreateTestViewModel createTestViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        createTestViewModel =
                ViewModelProviders.of(this).get(CreateTestViewModel.class);
        View root = inflater.inflate(R.layout.fragment_create_test, container, false);
//        final TextView textView = root.findViewById(R.id.text_share);
//        createTestViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}