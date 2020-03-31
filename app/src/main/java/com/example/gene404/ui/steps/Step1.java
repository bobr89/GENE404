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
    private TextView sensor3Display;

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
        sensor3Display = root.findViewById(R.id.sensorReading3);

        //Values
        flowValueInput = (EditText) root.findViewById(R.id.flowInput);
        flowValueInput.setCursorVisible(false);
        //Readings
        readingValue = root.findViewById(R.id.sensorReading);
        //Buttons
        setFlowButton = root.findViewById(R.id.set_flow);
//        getDataButton = root.findViewById(R.id.get_data);

        setFlowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                openViewLastTestFragment();

                flowValue = Integer.valueOf(flowValueInput.getText().toString());
//                readingValue.setText(String.valueOf(flowValue*200/70));

                jsonParseWithParameter(flowValue);
            }
        });

        flowResult = root.findViewById(R.id.flowResult);

        Button nextStepButton = root.findViewById(R.id.next_step);

        mQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

        //Buttons
        nextStepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextStepButtonFragment();
            }
        });

        jsonParse();

        return root;
    }

    public void nextStepButtonFragment() {
        Step2 newStep2 = new Step2();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newStep2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void jsonParse() {

        String url = "https://api.myjson.com/bins/kp9wz";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("employees");
                            sensor1Display.setText(response.toString().substring(0,3));
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject employee = jsonArray.getJSONObject(i);

                                String firstName = employee.getString("firstname");
                                int age = employee.getInt("age");
                                String mail = employee.getString("mail");

                                sensor1Display.append(firstName + ", " + String.valueOf(age) + ", " + mail + "\n\n");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }

    public void jsonParseWithParameter(float flowValue) {

        String url = "https://api.myjson.com/bins/kp9wz";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("employees");
                            flowResult.setText(response.toString().substring(0,3));
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject employee = jsonArray.getJSONObject(i);

                                String firstName = employee.getString("firstname");
                                int age = employee.getInt("age");
                                String mail = employee.getString("mail");

                                flowResult.append(firstName + ", " + String.valueOf(age) + ", " + mail + "\n\n");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }
}
