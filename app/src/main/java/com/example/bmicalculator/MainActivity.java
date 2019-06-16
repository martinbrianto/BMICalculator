package com.example.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float height, weight;
    float BMI;
    TextView result,status;
    EditText h,w;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.res);
        status = (TextView) findViewById(R.id.status);
        h = (EditText) findViewById(R.id.valheight);
        w = (EditText) findViewById(R.id.valweight);
        calculate = (Button)findViewById(R.id.calculateres);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            height = Float.parseFloat(h.getText().toString());
                weight = Float.parseFloat(w.getText().toString());


            if(height==0){
                result.setText("height cannot be 0");
            }else{
                BMI = weight/(height*height);

                result.setText(String.format("%.2f", BMI));
            }

            if(BMI<=18.5){
                status.setText("You are underweight");
            }else if (BMI>18.5 && BMI<=24.9){
                status.setText("You are normal");
            }else if (BMI>25 && BMI<=29.9){
                status.setText("You are overweight");
            }else if (BMI>30 && BMI<=34.9){
                status.setText("You are obese");
            }else if (BMI>35){
                status.setText("You are extremely obese");
            }
            }
        });
    }
}
