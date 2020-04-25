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
import com.example.gene404.ui.steps.Step1;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewTestFragment extends Fragment {

    private ViewTestViewModel viewTestViewModel;
    private TextView Sensor1Reading;
    private RequestQueue mQueue;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewTestViewModel =
                ViewModelProviders.of(this).get(ViewTestViewModel.class);
        View root = inflater.inflate(R.layout.fragment_view_test, container, false);

        Button nextStepButton = root.findViewById(R.id.next_step);

        Sensor1Reading = root.findViewById(R.id.Sensor1Reading);

        mQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

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
        ViewTestFragment2 newViewTestFragment2 = new ViewTestFragment2();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newViewTestFragment2);
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
                            Sensor1Reading.setText(response.toString());
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject employee = jsonArray.getJSONObject(i);

                                String firstName = employee.getString("firstname");
                                int age = employee.getInt("age");
                                String mail = employee.getString("mail");

                                Sensor1Reading.append(firstName + ", " + String.valueOf(age) + ", " + mail + "\n\n");
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