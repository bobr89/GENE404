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
import com.example.gene404.ui.dashboard.DashboardFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class ViewTestFragment3 extends Fragment {

    private ViewTestViewModel3 viewTestViewModel3;
    private TextView ResultsStatusReading;
    private RequestQueue mQueue;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewTestViewModel3 =
                ViewModelProviders.of(this).get(ViewTestViewModel3.class);
        View root = inflater.inflate(R.layout.fragment_view_test3, container, false);

        Button nextStepButton = root.findViewById(R.id.next_step);

        ResultsStatusReading = root.findViewById(R.id.Test3ResultsStatusReading);
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
        DashboardFragment newDashboardFragment = new DashboardFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newDashboardFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void jsonParse() {

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
