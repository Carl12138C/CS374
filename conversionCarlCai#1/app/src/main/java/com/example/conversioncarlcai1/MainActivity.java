package com.example.conversioncarlcai1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText milesInput;
    private TextView kmOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        milesInput = (EditText)findViewById(R.id.inputText);
        kmOutput = (TextView) findViewById(R.id.outputText);
    }

    public void convert(View view){
        String input = milesInput.getText().toString();
        try{
            double inputNum = Double.parseDouble(input);
            if(inputNum>1000000000){
                kmOutput.setText("Input too big!");
                return;
            }
            double outputNum = inputNum *1.61;
            kmOutput.setText(String.format("%.2f",outputNum));
        }
        catch (Exception e){
            kmOutput.setText("Invalid Input!");
        }
    }
}