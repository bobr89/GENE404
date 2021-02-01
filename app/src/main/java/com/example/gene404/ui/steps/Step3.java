package com.example.gene404.ui.steps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Step3 extends Fragment {

    private Step3ViewModel step3ViewModel;

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private Button nextStepButton;

    private View.OnClickListener onClickListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Is the view now checked?
            boolean checked = ((CheckBox) v).isChecked();

            if (checked) {
                String url = "https://jsonplaceholder.typicode.com/posts/1";

                Map<String, Boolean> params = new HashMap<String, Boolean>();
                params.put("Quick Charge", checked);
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

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

                mQueue.add(jsonObjectRequest);
            } else {
                return;
            }
        }
    };

    private View.OnClickListener onClickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean checked = ((CheckBox) v).isChecked();

            if (checked) {
                String url = "https://jsonplaceholder.typicode.com/posts/1";

                Map<String, Boolean> params = new HashMap<String, Boolean>();
                params.put("Service Reduction", checked);
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

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

                mQueue.add(jsonObjectRequest);
            } else {
                return;
            }
        }
    };

    private View.OnClickListener onClickListener3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean checked = ((CheckBox) v).isChecked();

            if (checked) {
                nextStepButton.setEnabled(true);
            } else {
                nextStepButton.setEnabled(false);
            }
        }
    };

    private TextView flowResult;
    private RequestQueue mQueue;

    float flowValue;

    private Button setFlowButton;
    private EditText flowValueInput;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        step3ViewModel =
                ViewModelProviders.of(this).get(Step3ViewModel.class);
        View root = inflater.inflate(R.layout.step3, container, false);

        mQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

        nextStepButton = root.findViewById(R.id.next_step);
        nextStepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextStepButtonFragment();
            }
        });

        flowValueInput = (EditText) root.findViewById(R.id.flowInput1);
        flowValueInput.setCursorVisible(false);

        setFlowButton = root.findViewById(R.id.set_flow1);
        setFlowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flowValue = Integer.valueOf(flowValueInput.getText().toString());
                jsonParseWithParameter(flowValue);
            }
        });

        flowResult = root.findViewById(R.id.flowResult);

        checkBox1 = root.findViewById(R.id.checkbox1);
        checkBox1.setOnClickListener(onClickListener1);

        checkBox2 = root.findViewById(R.id.checkbox2);
        checkBox2.setOnClickListener(onClickListener2);

        checkBox3 = root.findViewById(R.id.checkbox3);
        checkBox3.setOnClickListener(onClickListener3);

        return root;
    }

    public void nextStepButtonFragment() {
        Step4 newStep4 = new Step4();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newStep4);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
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
