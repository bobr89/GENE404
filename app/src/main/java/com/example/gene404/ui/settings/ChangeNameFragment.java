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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import com.example.gene404.R;
import com.example.gene404.ui.settings.ChangeNameViewModel;
import com.example.gene404.ui.viewTest.ViewTestFragment;
import com.example.gene404.ui.steps.Step1;
//import com.squareup.okhttp.Request;
//import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChangeNameFragment extends Fragment {

    private ChangeNameViewModel changeNameViewModel;
    private TextView textViewDisplay;
    private RequestQueue mQueue;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        changeNameViewModel =
                ViewModelProviders.of(this).get(ChangeNameViewModel.class);
        View root = inflater.inflate(R.layout.fragment_change_names, container, false);

        return root;
    }

    // change name api
//    public void changeName() {
//
//        String url = "https://jsonplaceholder.typicode.com/todos/1";
//
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                        }
//                        catch (OutOfMemoryError e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        });
//
//        mQueue.add(request);
//    }
}