package com.example.gene404.ui.steps;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.gene404.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

public class Step4 extends Fragment {
    private Step4ViewModel step4ViewModel;

    private TextView sensorDisplay;
    private RequestQueue mQueue;
    private CheckBox checkBox;

    private Button nextStepButton;
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Is the view now checked?
            boolean checked = ((CheckBox) v).isChecked();

            if (checked) {
                nextStepButton.setEnabled(true);
            } else {
                nextStepButton.setEnabled(false);
            }
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        step4ViewModel =
                ViewModelProviders.of(this).get(Step4ViewModel.class);
        View root = inflater.inflate(R.layout.step4, container, false);

        sensorDisplay = root.findViewById(R.id.sensorReading);

        mQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

        checkBox = root.findViewById(R.id.checkbox1);
        checkBox.setOnClickListener(onClickListener);

        nextStepButton = root.findViewById(R.id.next_step);
        nextStepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextStepButtonFragment();
            }
        });

        updateSensorValues();
        return root;
    }

    public void nextStepButtonFragment() {
        Summary newSummary = new Summary();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newSummary);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void updateSensorValues() {
        final Handler handler = new Handler();
        Timer timer = new Timer();
        TimerTask doAsynchronousTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        try {
                            jsonParse();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        };
        timer.schedule(doAsynchronousTask, 0, 3000); //execute in every 3000 ms
    }

    public void jsonParse() {

        String url = "https://jsonplaceholder.typicode.com/todos/1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                String sensor1 = "";

                try {
                    sensor1 = response.getString("id") +" Pa";
                } catch (JSONException error) {
                    error.printStackTrace();
                }

                sensorDisplay.setText(sensor1);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(jsonObjectRequest);
    }
}
