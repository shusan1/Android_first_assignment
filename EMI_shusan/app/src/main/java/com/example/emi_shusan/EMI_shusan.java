package com.example.emi_shusan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EMI_shusan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText principal, rt, mthinstall;
        final TextView Emi;
        Button calc;


        principal = (EditText) findViewById(R.id.pri);
        rt=(EditText) findViewById(R.id.rate);
        mthinstall= (EditText) findViewById(R.id.minst);
        Emi=(TextView) findViewById(R.id.emi);
        calc=(Button) findViewById(R.id.calculate);


        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String spri = principal.getText().toString();
                String srt = rt.getText().toString();
                String smti = mthinstall.getText().toString();



                if (spri.equals("")){
                    principal.setError("Enter Loan Amount");
                    principal.requestFocus();
                    return;
                }

                if (srt.equals("")){
                    rt.setError("Enter Rate per annum");
                    rt.requestFocus();
                    return;
                }

                if (smti.equals("")){
                    mthinstall.setError("Enter Months");
                    mthinstall.requestFocus();
                    return;
                }


                float principal = Float.parseFloat(spri);
                float rat = Float.parseFloat(srt);
                float mthinstall = Float.parseFloat(smti);
                float value = EMI_calculate(principal,rate_calc(rat), mthinstall);


                Emi.setText("EMI= $"+ String.format("%.2f",value));


            }
        });


    }

    public float rate_calc(float rt ){
        final float rat = rt / 1200;
        return rat;

    }


    public float EMI_calculate(float principal, float rat, float mthinstall) {
        return (float) (principal * rat * Math.pow((1 + rat), mthinstall) / (Math.pow((1 + rat), (mthinstall))-1));
    }




}


