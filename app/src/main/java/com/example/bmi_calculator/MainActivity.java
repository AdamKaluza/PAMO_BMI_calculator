package com.example.bmi_calculator;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.bmi_calculator.databinding.ActivityMainBinding;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result;

    private String weight;

    private String height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.bmi_calculator.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView weightInKg = (EditText) findViewById(R.id.weightInKg);
        TextView heightInCm = (EditText) findViewById(R.id.heightInCm);
        result = (TextView) findViewById(R.id.result);
        Button confirm = (Button) findViewById(R.id.confirm);

        weightInKg.addTextChangedListener(weightInKgWatcher);
        heightInCm.addTextChangedListener(heightInCmWatcher);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });
    }

    private void calculate() {
        if (!height.isEmpty() && !weight.isEmpty()) {
            Resources res = getResources();
            Double bmi = Double.parseDouble(weight) / Math.pow(Double.parseDouble(height) / 100, 2);
            String text = String.format(res.getString(R.string.result), bmi);
            result.setText(text);
        }
    }

    private final TextWatcher weightInKgWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            weight = charSequence.toString();
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private final TextWatcher heightInCmWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            height = charSequence.toString();
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}