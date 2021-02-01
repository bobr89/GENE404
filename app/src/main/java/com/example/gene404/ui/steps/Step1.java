package com.example.gene404.ui.steps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
import com.example.gene404.ui.runTest.RunTestViewModel;
import com.example.gene404.ui.steps.Step1ViewModel;
import com.example.gene404.ui.viewTest.ViewTestFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import android.os.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Step1 extends Fragment {

    private Step1ViewModel step1ViewModel;

    float flowValue;

    //Buttons
    private Button setFlowButton;
//    private Button getDataButton;
    private EditText flowValueInput;
    private TextView readingValue;

    private TextView sensor1Display;
    private TextView sensor2Display;
//    private TextView sensor3Display;

    private TextView flowResult;

    private RequestQueue mQueue;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        step1ViewModel =
                ViewModelProviders.of(this).get(Step1ViewModel.class);
        View root = inflater.inflate(R.layout.step1, container, false);

        //Sensor1 Display
        sensor1Display = root.findViewById(R.id.sensorReading1);
        sensor2Display = root.findViewById(R.id.sensorReading2);
//        sensor3Display = root.findViewById(R.id.sensorReading3);

        //Values
        flowValueInput = (EditText) root.findViewById(R.id.flowInput);
        flowValueInput.setCursorVisible(false);
        //Readings
        readingValue = root.findViewById(R.id.sensorReading);
        //Buttons
        setFlowButton = root.findViewById(R.id.set_flow);

        setFlowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flowValue = Integer.valueOf(flowValueInput.getText().toString());
                jsonParseWithParameter(flowValue);
            }
        });

        flowResult = root.findViewById(R.id.flowResult);

        Button nextStepButton = root.findViewById(R.id.next_step);

        mQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

        nextStepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextStepButtonFragment();
            }
        });

        updateSensorValues();
//        jsonParse();

        return root;
    }

    public void nextStepButtonFragment() {
        Step2 newStep2 = new Step2();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newStep2);
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
                String sensor2 = "";

                try {
                    sensor1 = response.getString("id") +" Pa";
                    sensor2 = response.getString("id") +" Pa";
                } catch (JSONException error) {
                    error.printStackTrace();
                }

                sensor1Display.setText(sensor1);
                sensor2Display.setText(sensor2);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(jsonObjectRequest);
    }

    public void jsonParseWithParameter(float flowValue) {

        String url = "https://jsonplaceholder.typicode.com/posts/1";
        Integer intflowValue = Math.round(flowValue);

        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("Flow Value", intflowValue);
        JSONObject jsonObj = new JSONObject(params);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, url, jsonObj, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                String status = "";

                if (response != null){
                    status = "Response: success";
                } else {
                    status = "Response: fail";
                }

                flowResult.setText(status);
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
