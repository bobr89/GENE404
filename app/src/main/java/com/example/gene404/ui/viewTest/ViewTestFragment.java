package com.example.gene404.ui.viewTest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.gene404.R;
import com.example.gene404.ui.steps.Step1;

public class ViewTestFragment extends Fragment {

    private ViewTestViewModel viewTestViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewTestViewModel =
                ViewModelProviders.of(this).get(ViewTestViewModel.class);
        View root = inflater.inflate(R.layout.fragment_view_test, container, false);

        Button nextStepButton = root.findViewById(R.id.next_step);

        //Buttons
        nextStepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextStepButtonFragment();
            }
        });

        return root;
    }

    public void nextStepButtonFragment() {
        ViewTestFragment2 newViewTestFragment2 = new ViewTestFragment2();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newViewTestFragment2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}