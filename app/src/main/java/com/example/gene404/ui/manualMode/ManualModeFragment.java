package com.example.gene404.ui.manualMode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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

import java.util.HashMap;
import java.util.Map;


public class ManualModeFragment extends Fragment {

    private ToolsViewModel toolsViewModel;
    private TextView ResultsStatusReading;
    private Button testBaseStationConnectionButton;
    private Button turnValveOnButton;
    private Button turnValveOffButton;
    private Button testPressureSensor1Button;
    private Button testPressureSensor2Button;

    private RequestQueue mQueue;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_manual_mode, container, false);

        testBaseStationConnectionButton = root.findViewById(R.id.test_basestation_connection_button);
        turnValveOnButton = root.findViewById(R.id.valve_on);
        turnValveOffButton = root.findViewById(R.id.valve_off);
        testPressureSensor1Button = root.findViewById(R.id.test_pressure_sensor_1);
        testPressureSensor2Button = root.findViewById(R.id.test_pressure_sensor_2);

        ResultsStatusReading = root.findViewById(R.id.ManualModeStatusReading);

        mQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

        //Buttons
        testBaseStationConnectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testBaseStationConnection();
            }
        });

        turnValveOnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnValveOn();
            }
        });

        turnValveOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnValveOff();
            }
        });

        testPressureSensor1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testPressureSensor1();
            }
        });

        testPressureSensor2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testPressureSensor2();
            }
        });

        return root;
    }

    public void testBaseStationConnection() {
        String url = "https://jsonplaceholder.typicode.com/todos/1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                String status = "";

                try {
                    status = "Response: " +response.getString("completed");
                } catch (JSONException error) {
                    error.printStackTrace();
                }

                ResultsStatusReading.setText(status);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(jsonObjectRequest);
    }

    public void turnValveOn() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        Map<String, Boolean> params = new HashMap<String, Boolean>();
        params.put("Valve", true);
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

                ResultsStatusReading.setText(status);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(jsonObjectRequest);
    }

    public void turnValveOff() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        Map<String, Boolean> params = new HashMap<String, Boolean>();
        params.put("Valve", false);
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

                ResultsStatusReading.setText(status);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(jsonObjectRequest);
    }

    public void testPressureSensor1() {
        String url = "https://jsonplaceholder.typicode.com/todos/1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                String status = "";

                try {
                    status = "Response: " +response.getString("completed");
                } catch (JSONException error) {
                    error.printStackTrace();
                }

                ResultsStatusReading.setText(status);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(jsonObjectRequest);
    }

    public void testPressureSensor2() {
        String url = "https://jsonplaceholder.typicode.com/todos/1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                String status = "";

                try {
                    status = "Response: " +response.getString("completed");
                } catch (JSONException error) {
                    error.printStackTrace();
                }

                ResultsStatusReading.setText(status);
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