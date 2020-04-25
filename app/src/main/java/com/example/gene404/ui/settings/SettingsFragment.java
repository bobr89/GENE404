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
//        final TextView textView = root.findViewById(R.id.text_send);
//        settingsViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        text_send = root.findViewById(R.id.log_text);
        mQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        jsonParse();

        Button nextStepButton = root.findViewById(R.id.change_name);

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
        ChangeNameFragment newChangeNameFragment = new ChangeNameFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newChangeNameFragment);
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
                            text_send.setText(response.toString());
//                            for (int i = 0; i < jsonArray.length(); i++) {
//                                JSONObject employee = jsonArray.getJSONObject(i);
//
//                                String firstName = employee.getString("firstname");
//                                int age = employee.getInt("age");
//                                String mail = employee.getString("mail");
//
//                                text_send.append(firstName + ", " + String.valueOf(age) + ", " + mail + "\n\n");
//                            }
                        } catch (OutOfMemoryError e) {
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