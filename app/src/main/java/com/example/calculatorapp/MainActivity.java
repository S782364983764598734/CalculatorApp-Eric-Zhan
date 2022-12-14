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
    int pos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializes Spinner class in order for users to select the operator that they want
        //https://www.youtube.com/watch?v=on_OrrX7Nw4
        Spinner op = (Spinner)findViewById(R.id.operator);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.operator, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        op.setAdapter(adapter);
        op.setOnItemSelectedListener(this);
    }

    //this class determines which operator to use, depending on what operator the user chooses
    //https://stackoverflow.com/questions/10331854/how-to-get-spinner-selected-item-value-to-string
    public void operation(View view)
    {
        if (pos == 0)
        {
            findSum();
        }
        else if (pos == 1)
        {
            findDifference();
        }
        else if (pos == 2)
        {
            findProduct();
        }
        else if (pos == 3)
        {
            findQuotient();
        }
    }

    public void findSum() {
        EditText number1ET = findViewById(R.id.num1ET);
        EditText number2ET = findViewById(R.id.num2ET);
        TextView numberSumTV = findViewById(R.id.resultTV);

        if (checkNum(number1ET.getText().toString()) && checkNum(number2ET.getText().toString()))
        {
            double num1 = Integer.parseInt((number1ET.getText().toString()));
            double num2 = Integer.parseInt((number2ET.getText().toString()));
            double sum = num1 + num2;
            numberSumTV.setText("" + sum);
        }
        else
        {
            numberSumTV.setText("ENTER NUMERIC VALUES  ");
        }

    }

    public void findDifference() {
        EditText number1ET = findViewById(R.id.num1ET);
        EditText number2ET = findViewById(R.id.num2ET);
        TextView numberSumTV = findViewById(R.id.resultTV);

        double num1 = Integer.parseInt((number1ET.getText().toString()));
        double num2 = Integer.parseInt((number2ET.getText().toString()));
        double diff = num1 - num2;

        numberSumTV.setText("" + diff);
    }
    public void findProduct() {
        EditText number1ET = findViewById(R.id.num1ET);
        EditText number2ET = findViewById(R.id.num2ET);
        TextView numberSumTV = findViewById(R.id.resultTV);

        double num1 = Integer.parseInt((number1ET.getText().toString()));
        double num2 = Integer.parseInt((number2ET.getText().toString()));
        double prod = num1 * num2;

        numberSumTV.setText("" + prod);
    }
    public void findQuotient() {
        EditText number1ET = findViewById(R.id.num1ET);
        EditText number2ET = findViewById(R.id.num2ET);
        TextView numberSumTV = findViewById(R.id.resultTV);

        double num1 = Integer.parseInt((number1ET.getText().toString()));
        double num2 = Integer.parseInt((number2ET.getText().toString()));
        double quot =  num1 / num2;

        numberSumTV.setText("" + quot);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
        pos = position;

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    //this function returns if user input is a number.
    public boolean checkNum(String input)
    {
        String[] tempInput = input.split("");
        int temp = 0;
        for (int i = 0; i < tempInput.length;i++)
        {
            if (tempInput[i].equals("1") || tempInput[i].equals("2") || tempInput[i].equals("3") || tempInput[i].equals("4")|| tempInput[i].equals("5")|| tempInput[i].equals("6")|| tempInput[i].equals("7")|| tempInput[i].equals("8")|| tempInput[i].equals("9")|| tempInput[i].equals("0"))
            {
                temp ++;
            }
            else
            {
                temp --;
            }
        }
        if(temp == tempInput.length)
        {
            return true;
        }
        else
        {
            return false;
        }


    }
}