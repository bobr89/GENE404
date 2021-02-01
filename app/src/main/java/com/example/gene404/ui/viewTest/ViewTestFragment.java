package com.example.gene404.ui.viewTest;

import android.os.AsyncTask;
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
import com.example.gene404.ViewTestAdapter;
import com.example.gene404.ViewTestModel;
import com.example.gene404.ui.steps.Step1;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;
import android.util.Log;

public class ViewTestFragment extends Fragment {

    private ViewTestViewModel viewTestViewModel;
    private RequestQueue mQueue;

    private RecyclerView recycler_view;
    private ViewTestAdapter adapter;

    public List<ViewTestModel> view_test_list = new ArrayList<>();;
    public JSONArray array = new JSONArray();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewTestViewModel =
                ViewModelProviders.of(this).get(ViewTestViewModel.class);
        View root = inflater.inflate(R.layout.fragment_view_test, container, false);

        recycler_view = root.findViewById(R.id.recycler_view);
        mQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

        ApiGetRequest request = new ApiGetRequest();
        request.doInBackground("example");

        return root;
    }

    public class ApiGetRequest extends AsyncTask<String, Void, JSONArray> {

        @Override
        protected JSONArray doInBackground(String... strings) {

            String url = "https://jsonplaceholder.typicode.com/todos";

            JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            onPostExecute(response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });

            mQueue.add(request);
            return array;
        }

        @Override
        protected void onPostExecute(JSONArray array) {
            int maxOutputTests = 8;

            try {
                for (int i = 0; i < maxOutputTests; i++) {
                    JSONObject test = array.getJSONObject(i);

                    String testId = test.getString("id");
                    String testResponse;

                    //Simulate test result responses
                    if (test.getString("completed") == "false") {
                        testResponse = "Success";
                    } else {
                        testResponse = "Fail";
                    }

                    //Simulate actual pressure values
                    Double sensor1FloatValue = (double) test.getString("title").length()/55;
                    Double sensor2FloatValue = (double) test.getString("title").length()/33;
                    String testSensor1 = String.format("%.2f", sensor1FloatValue);
                    String testSensor2 = String.format("%.2f", sensor2FloatValue);

                    view_test_list.add(new ViewTestModel(testId, testResponse, testSensor1, testSensor2));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

//            System.out.println(view_test_list);
            setRecyclerView();
        }
    }

    private void setRecyclerView() {
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ViewTestAdapter(getContext(), view_test_list);
        recycler_view.setAdapter(adapter);
    }
}