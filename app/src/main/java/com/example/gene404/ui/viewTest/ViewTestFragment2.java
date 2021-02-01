package com.example.gene404.ui.viewTest;

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

import org.json.JSONException;
import org.json.JSONObject;

public class ViewTestFragment2 extends Fragment {

    private ViewTestViewModel2 viewTestViewModel2;
    private TextView Sensor1Reading;
    private TextView Sensor2Reading;
    private TextView Sensor3Reading;
    private TextView ResultsStatusReading;
    private RequestQueue mQueue;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewTestViewModel2 =
                ViewModelProviders.of(this).get(ViewTestViewModel2.class);
        View root = inflater.inflate(R.layout.fragment_view_test2, container, false);

        Button nextStepButton = root.findViewById(R.id.next_step);

        Sensor1Reading = root.findViewById(R.id.Test2Sensor1Reading);
        Sensor2Reading = root.findViewById(R.id.Test2Sensor2Reading);
        Sensor3Reading = root.findViewById(R.id.Test2Sensor3Reading);
        ResultsStatusReading = root.findViewById(R.id.Test2ResultsStatusReading);

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
        ViewTestFragment3 newViewTestFragment3 = new ViewTestFragment3();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newViewTestFragment3);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void jsonParse() {

        String url = "https://jsonplaceholder.typicode.com/todos/1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                String status = "";
                String sensor1 = "";
                String sensor2 = "";
                String sensor3 = "";

                try {
                    status = "Response: " +response.getString("completed");
                    sensor1 = "Sensor 1: " +response.getString("id") +" Pa";
                    sensor2 = "Sensor 2: " +response.getString("id") +" Pa";
                    sensor3 = "Sensor 3: " +response.getString("id") +" Pa";
                } catch (JSONException error) {
                    error.printStackTrace();
                }

                Sensor1Reading.setText(sensor1);
                Sensor2Reading.setText(sensor2);
                Sensor3Reading.setText(sensor3);
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
