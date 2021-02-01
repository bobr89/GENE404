package com.example.gene404.ui.steps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.gene404.R;

import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.CompoundButton;

public class Step2 extends Fragment {

    private Step2ViewModel step2ViewModel;

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;

    private Integer checkBoxCounter = 0;

    private Button nextStepButton;

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Is the view now checked?
            boolean checked = ((CheckBox) v).isChecked();

            if (checked) {
                checkBoxCounter ++;
            } else {
                checkBoxCounter --;
            }

            if (checkBoxCounter == 4) {
                nextStepButton.setEnabled(true);
            }
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        step2ViewModel =
                ViewModelProviders.of(this).get(Step2ViewModel.class);
        View root = inflater.inflate(R.layout.step2, container, false);

        nextStepButton = root.findViewById(R.id.next_step);
        nextStepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextStepButtonFragment();
            }
        });

        checkBox1 = root.findViewById(R.id.checkbox1);
        checkBox1.setOnClickListener(onClickListener);
        checkBox2 = root.findViewById(R.id.checkbox2);
        checkBox2.setOnClickListener(onClickListener);
        checkBox3 = root.findViewById(R.id.checkbox3);
        checkBox3.setOnClickListener(onClickListener);
        checkBox4 = root.findViewById(R.id.checkbox4);
        checkBox4.setOnClickListener(onClickListener);

        return root;
    }

    public void nextStepButtonFragment() {
        Step3 newStep3 = new Step3();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, newStep3);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        if (checked) {
            checkBoxCounter ++;
        } else {
            checkBoxCounter --;
        }

        if (checkBoxCounter == 4) {
            nextStepButton.setEnabled(true);
        }
    }
}
