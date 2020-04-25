package com.example.gene404.ui.steps;

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

public class Step4 extends Fragment {
    private Step4ViewModel step4ViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        step4ViewModel =
                ViewModelProviders.of(this).get(Step4ViewModel.class);
        View root = inflater.inflate(R.layout.step4, container, false);

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
        Summary newSummary = new Summary();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newSummary);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}