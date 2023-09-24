package com.cs407.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        double result = intent.getDoubleExtra("result", 0);

        // Capture the layout's TextView and set the result as its text
        TextView textView = findViewById(R.id.textViewResult);
        textView.setText(Double.toString(result));
    }
}