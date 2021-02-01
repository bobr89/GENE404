package com.example.gene404.ui.settings;

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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.gene404.R;
import com.example.gene404.ui.steps.Step1;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingsFragment extends Fragment {

    private SettingsViewModel settingsViewModel;
    private TextView text_send;
    private RequestQueue mQueue;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        settingsViewModel =
                ViewModelProviders.of(this).get(SettingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        text_send = root.findViewById(R.id.log_text);

        mQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

        jsonParse();
        return root;
    }

    public void jsonParse() {

        String url = "https://jsonplaceholder.typicode.com/todos";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        int maxOutputLog = 5;
                        String output = "";

                        try {

                            for (int i = 0; i < maxOutputLog; i++) {
                                JSONObject todo = response.getJSONObject(i);

                                String userId = todo.getString("userId");
                                String log = todo.getString("title");

                                output += "  User: " + userId + ", Log: " + log + "\n";
                            }

                            text_send.setText(output.toString());
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