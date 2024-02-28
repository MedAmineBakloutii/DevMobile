package com.example.tp1_calcul;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private EditText firstValueEditText, secondValueEditText;
    private RadioGroup operationsRadioGroup;
    private TextView resultTextView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstValueEditText = findViewById(R.id.firstValue);
        secondValueEditText = findViewById(R.id.secondValue);
        operationsRadioGroup = findViewById(R.id.operations);
        resultTextView = findViewById(R.id.result);
        calculateButton = findViewById(R.id.calculateBtn);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });

        // Set OnCheckedChangeListener for RadioGroup to update result when operator changes
        operationsRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                calculateResult();
            }
        });
    }

    private void calculateResult() {
        double firstValue = Double.parseDouble(firstValueEditText.getText().toString());
        double secondValue = Double.parseDouble(secondValueEditText.getText().toString());
        double result = 0;

        int checkedRadioButtonId = operationsRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(checkedRadioButtonId);

        if (checkedRadioButtonId != -1 && selectedRadioButton != null) {
            if (checkedRadioButtonId == R.id.plus) {
                result = firstValue + secondValue;
            } else if (checkedRadioButtonId == R.id.minus) {
                result = firstValue - secondValue;
            } else if (checkedRadioButtonId == R.id.multiply) {
                result = firstValue * secondValue;
            } else if (checkedRadioButtonId == R.id.devide) {
                if (secondValue != 0) {
                    result = firstValue / secondValue;
                } else {
                    result = Double.NaN;
                }
            }
        }

        resultTextView.setText("Result: " + result);
    }

}

