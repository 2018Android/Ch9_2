package com.example.admin.ch9_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        displayBMI();
        Button btn_BMIBack = (Button)findViewById(R.id.btn_BMIBack);
        btn_BMIBack.setOnClickListener(btn_BMIBackListener);
    }

    private void displayBMI(){
        double height, weight, bmi;
        Bundle bundle = this.getIntent().getExtras();
        if(bundle != null){
            height = Double.parseDouble(bundle.getString("HEIGHT"));
            weight = Double.parseDouble(bundle.getString("WEIGHT"));
            height = height/100.00;
            bmi = weight/(height*height);
            TextView txv_BMIResult = (TextView)findViewById(R.id.txv_BMIResult);
            txv_BMIResult.setText("BMI值："+Double.toString(bmi));
        }
    }

    View.OnClickListener btn_BMIBackListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}
