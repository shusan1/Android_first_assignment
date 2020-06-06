package com.example.bmi_shusan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMI_shusan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText Wei, Hei;
        final TextView Rslt, Bmi ;
        Button calc;


        Wei = (EditText) findViewById(R.id.weight );
        Hei = (EditText) findViewById(R.id.height);
        Rslt = (TextView) findViewById(R.id.result);
        Bmi = (TextView)findViewById(R.id.bmi);
        calc= (Button) findViewById(R.id.calculate);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String shei = Hei.getText().toString();
                String swei = Wei.getText().toString();

             if (swei.equals("")){
                 Wei.setError("Enter Weight");
                 Wei.requestFocus();
                 return;
                }


                if (shei.equals("")){
                    Hei.setError("Enter Height");
                    Hei.requestFocus();
                    return;
                }

             float height = Float.parseFloat(shei);
             float weight = Float.parseFloat(swei);
             float value = BMI_calculate(height, weight);


             Bmi.setText("BMI= "+ String.format("%.2f",value));
             Rslt.setText(BMI_val(value));


            }
        });


    }




    public float BMI_calculate(float height, float weight){

        return weight /(height * height);
    }

    public String BMI_val (float value ){
        if (value < 18.5){
            return "Underweight";
        }
        else if (value < 24.9){
            return "Normal Weight";
        }
        else if (value < 29.9){
            return "Overweight";
        }
        else
            return "Overweight";
    }
}