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

public class ViewTestFragment2 extends Fragment {

    private ViewTestViewModel2 viewTestViewModel2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewTestViewModel2 =
                ViewModelProviders.of(this).get(ViewTestViewModel2.class);
        View root = inflater.inflate(R.layout.fragment_view_test2, container, false);

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
        ViewTestFragment3 newViewTestFragment3 = new ViewTestFragment3();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newViewTestFragment3);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
