package com.alam292.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtNo1, edtNo2;
    Button buttonAdd, buttonSub, buttonMul, buttonDiv;
    TextView resultView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the EditTexts
        edtNo1 = findViewById(R.id.edtNo1);
        edtNo2 = findViewById(R.id.edtNo2);

        // Initialize the Buttons
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSub = findViewById(R.id.buttonSub);
        buttonMul = findViewById(R.id.buttonMul);
        buttonDiv = findViewById(R.id.buttonDiv);

        // Initialize the TextView for displaying the result
        resultView = findViewById(R.id.answer);

        // Set click listeners for each button
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.ADD);
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.SUBTRACT);
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.MULTIPLY);
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.DIVIDE);
            }
        });
    }

    private void performOperation(Operation operation) {
        double no1, no2;

        // Get numbers from EditTexts with error handling
        try {
            no1 = Double.parseDouble(edtNo1.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input for number 1", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            no2 = Double.parseDouble(edtNo2.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input for number 2", Toast.LENGTH_SHORT).show();
            return;
        }

        double result;

        // Perform the operation
        switch (operation) {
            case ADD:
                result = no1 + no2;
                break;
            case SUBTRACT:
                result = no1 - no2;
                break;
            case MULTIPLY:
                result = no1 * no2;
                break;
            case DIVIDE:
                if (no2 == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = no1 / no2;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operation);
        }

        // Display the result
        resultView.setText(String.valueOf(result));
    }

    enum Operation {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    }
}
