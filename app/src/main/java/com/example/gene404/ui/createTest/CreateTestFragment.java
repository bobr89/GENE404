package com.example.gene404.ui.createTest;

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
import com.example.gene404.ui.dashboard.DashboardFragment;

public class CreateTestFragment extends Fragment {

    private CreateTestViewModel createTestViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        createTestViewModel =
                ViewModelProviders.of(this).get(CreateTestViewModel.class);
        View root = inflater.inflate(R.layout.fragment_create_test, container, false);

        Button pressureTestButton = root.findViewById(R.id.pressure_test);
        Button connectionTestButton = root.findViewById(R.id.connection_test);
        Button sensorTestButton = root.findViewById(R.id.sensor_test);

        //Buttons
        pressureTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressureTestButtonFragment();
            }
        });
        connectionTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectionTestButtonFragment();
            }
        });
        sensorTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sensorTestButtonFragment();
            }
        });

        return root;
    }

    public void pressureTestButtonFragment() {
        PressureTestFragment newPressureTestFragment = new PressureTestFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newPressureTestFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void connectionTestButtonFragment() {
        ConnectionTestFragment newConnectionTestFragment = new ConnectionTestFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newConnectionTestFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void sensorTestButtonFragment() {
        SensorTestFragment newSensorTestFragment = new SensorTestFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newSensorTestFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}