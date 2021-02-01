package com.example.gene404;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;

public class ViewTestAdapter extends RecyclerView.Adapter<ViewTestAdapter.ViewHolder> {

    Context context;
    List<ViewTestModel> view_test_list;

    public ViewTestAdapter(Context context,List<ViewTestModel> view_test_list) {
        this.context = context;
        this.view_test_list = view_test_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (view_test_list != null && view_test_list.size() > 0){
            ViewTestModel model = view_test_list.get(position);
            holder.id_test.setText(model.getId());
            holder.response_test.setText(model.getResponse());
            holder.sensor1_test.setText(model.getSensor1());
            holder.sensor2_test.setText(model.getSensor2());
        } else {
            return;
        }
    }

    @Override
    public int getItemCount() {
        return view_test_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id_test, response_test, sensor1_test, sensor2_test;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id_test = itemView.findViewById(R.id.id_test);
            response_test = itemView.findViewById(R.id.response_test);
            sensor1_test = itemView.findViewById(R.id.sensor1_test);
            sensor2_test = itemView.findViewById(R.id.sensor2_test);
        }
    }
}