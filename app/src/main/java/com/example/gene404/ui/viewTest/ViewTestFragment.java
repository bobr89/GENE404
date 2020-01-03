package com.example.gene404.ui.viewTest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.gene404.R;

public class ViewTestFragment extends Fragment {

    private ViewTestViewModel viewTestViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewTestViewModel =
                ViewModelProviders.of(this).get(ViewTestViewModel.class);
        View root = inflater.inflate(R.layout.fragment_view_test, container, false);
//        final TextView textView = root.findViewById(R.id.text_slideshow);
//        viewTestViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}