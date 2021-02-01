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
import com.example.gene404.ui.runTest.RunTestFragment;
import com.example.gene404.ui.viewTest.ViewTestFragment;
import com.example.gene404.ui.manualMode.ManualModeFragment;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    //Buttons
    private Button viewTestButton;
    private Button runTestButton;
    private Button manualModeButton;
    private Button settingsButton;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        //Buttons
        viewTestButton = (Button) root.findViewById(R.id.view_last_test);
        runTestButton = root.findViewById(R.id.run_test);
        manualModeButton = root.findViewById(R.id.manual_mode);
        settingsButton = root.findViewById(R.id.settings);

        //Buttons
        viewTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewLastTestFragment();
            }
        });
        runTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRunTestFragment();
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

    public void openRunTestFragment() {
        RunTestFragment newRunTestFragment = new RunTestFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newRunTestFragment);
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