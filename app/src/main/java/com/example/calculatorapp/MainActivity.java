package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] operators = {"+","-","*","/"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializes Spinner class in order for users to select the operator that they want
        Spinner op = (Spinner)findViewById(R.id.operator);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.operator, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        op.setAdapter(adapter);
        op.setOnItemSelectedListener(this);
        @Override
            public void operation(View view)
            {
                String current = op.getSelectedItem().toString();
            }
    }

    //this class determines which operator to use, depending on what operator the user chooses


    public void findSum(View view) {
        EditText number1ET = findViewById(R.id.num1ET);
        EditText number2ET = findViewById(R.id.num2ET);
        TextView numberSumTV = findViewById(R.id.resultTV);

        int num1 = Integer.parseInt((number1ET.getText().toString()));
        int num2 = Integer.parseInt((number2ET.getText().toString()));
        int sum = num1 + num2;

        numberSumTV.setText("" + sum);
    }

    public void findDifference(View view) {
        EditText number1ET = findViewById(R.id.num1ET);
        EditText number2ET = findViewById(R.id.num2ET);
        TextView numberSumTV = findViewById(R.id.resultTV);

        int num1 = Integer.parseInt((number1ET.getText().toString()));
        int num2 = Integer.parseInt((number2ET.getText().toString()));
        int diff = num1 - num2;

        numberSumTV.setText("" + diff);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}