package com.example.tp1currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText amount;
    private TextView result;
    private Button btnConvert;
    private RadioButton eurToTnd;
    private RadioButton tndToEur;
    private double tndToEurRate = 0.296;
    private double eurToTndRate = 3.37;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amount = findViewById(R.id.amount);
        result = findViewById(R.id.result);
        btnConvert = findViewById(R.id.btnConvert);
        eurToTnd = findViewById(R.id.eurToTnd);
        tndToEur = findViewById(R.id.tndToEur);

        amount.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){
            }
            @Override
            public void afterTextChanged(Editable s) {
                emptyCurrency();
            }
        });

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrency();
            }
        });
    }

    private void emptyCurrency() {
        String amountStr = amount.getText().toString().trim();

        if (amountStr.isEmpty()) {
            result.setText("");
            return;
        }
    }

    private void convertCurrency() {
        String amountStr = amount.getText().toString().trim();

        if (amountStr.isEmpty()) {
            result.setText("");
            return;
        }
        double amount = Double.parseDouble(amountStr);
        double convertedResult;

        if (eurToTnd.isChecked()) {
            // Convert from EUR to TND
            convertedResult = amount * eurToTndRate;
            result.setText(String.format("%.2f TND", convertedResult));
        } else if (tndToEur.isChecked()) {
            // Convert from TND to EUR
            convertedResult = amount * tndToEurRate;
            result.setText(String.format("%.2f EUR", convertedResult));
        }
    }



}