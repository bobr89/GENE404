package com.example.gene404.ui.dashboard;

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
import com.example.gene404.ui.settings.SettingsFragment;
import com.example.gene404.ui.createTest.CreateTestFragment;
import com.example.gene404.ui.viewTest.ViewTestFragment;
import com.example.gene404.ui.manualMode.ManualModeFragment;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    //Buttons
    private Button viewTestButton;
    private Button createNewTestButton;
    private Button manualModeButton;
    private Button settingsButton;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        //Buttons
        viewTestButton = (Button) root.findViewById(R.id.view_last_test);
        createNewTestButton = root.findViewById(R.id.create_new_task);
        manualModeButton = root.findViewById(R.id.manual_mode);
        settingsButton = root.findViewById(R.id.settings);

        //Buttons
        viewTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewLastTestFragment();
            }
        });
        createNewTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateNewTestFragment();
            }
        });

        manualModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openManualModeFragment();
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsFragment();
            }
        });
        return root;
    }

    public void openViewLastTestFragment() {
        ViewTestFragment newGalleryFragment = new ViewTestFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newGalleryFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void openCreateNewTestFragment() {
        CreateTestFragment newCreateTestFragment = new CreateTestFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newCreateTestFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void openManualModeFragment() {
        ManualModeFragment newManualModeFragment = new ManualModeFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newManualModeFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void openSettingsFragment() {
        SettingsFragment newSettingsFragment = new SettingsFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newSettingsFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

//    public void openCreateNewTestActivity() {
//        Intent intent = new Intent(this, SettingsFragment.class);
//        startActivity(intent);
//    }
//
//    public void openManualModeActivity() {
//        Intent intent = new Intent(this, CreateTestFragment.class);
//        startActivity(intent);
//    }
//
//    public void openSettingsActivity() {
//        Intent intent = new Intent(this, ManualModeFragment.class);
//        startActivity(intent);
//    }
}