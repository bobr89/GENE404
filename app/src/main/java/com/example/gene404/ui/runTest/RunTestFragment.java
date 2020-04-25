package com.example.gene404.ui.runTest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.example.gene404.ui.viewTest.ViewTestFragment;
import com.example.gene404.ui.steps.Step1;
//import com.squareup.okhttp.Request;
//import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RunTestFragment extends Fragment {

    private RunTestViewModel runTestViewModel;
    private TextView textViewDisplay;
    private RequestQueue mQueue;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        runTestViewModel =
                ViewModelProviders.of(this).get(RunTestViewModel.class);
        View root = inflater.inflate(R.layout.fragment_run_test, container, false);
//        final TextView textView = root.findViewById(R.id.text_gallery);
//        runTestViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        })
        Button button = root.findViewById(R.id.start_test);
        textViewDisplay = root.findViewById(R.id.result_status);

        mQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                textViewDisplay.setText("Testing");
                jsonParse();
            }
        });

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
        Step1 newStep1 = new Step1();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newStep1);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void jsonParse() {

        String url = "https://jsonplaceholder.typicode.com/todos/1";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
//                            JSONArray jsonArray = response.getJSONArray("employees");
                            textViewDisplay.setText(response.toString());
//                            for (int i = 0; i < jsonArray.length(); i++) {
//                                JSONObject employee = jsonArray.getJSONObject(i);
//
//                                String firstName = employee.getString("firstname");
//                                int age = employee.getInt("age");
//                                String mail = employee.getString("mail");
//
//                                textViewDisplay.append(firstName + ", " + String.valueOf(age) + ", " + mail + "\n\n");
//                            }
                        }
                        catch (OutOfMemoryError e) {
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