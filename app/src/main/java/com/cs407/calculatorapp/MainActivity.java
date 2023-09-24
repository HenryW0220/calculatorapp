package com.cs407.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void addFunction(View view) {
        performOperation(Operation.ADD);
    }

    public void subtractFunction(View view) {
        performOperation(Operation.SUBTRACT);
    }

    public void multiplyFunction(View view) {
        performOperation(Operation.MULTIPLY);
    }

    public void divideFunction(View view) {
        performOperation(Operation.DIVIDE);
    }

    private void performOperation(Operation operation) {
        EditText editTextNumber1 = findViewById(R.id.editTextNumber1);
        EditText editTextNumber2 = findViewById(R.id.editTextNumber2);

        double num1;
        double num2;
        try {
            num1 = Double.parseDouble(editTextNumber1.getText().toString());
            num2 = Double.parseDouble(editTextNumber2.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
            return;
        }

        double result;
        switch (operation) {
            case ADD:
                result = num1 + num2;
                break;
            case SUBTRACT:
                result = num1 - num2;
                break;
            case MULTIPLY:
                result = num1 * num2;
                break;
            case DIVIDE:
                if (num2 == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operation);
        }

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }

    private enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
    }
}