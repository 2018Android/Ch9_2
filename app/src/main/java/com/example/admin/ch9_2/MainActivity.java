package com.example.admin.ch9_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_startSecond = (Button)findViewById(R.id.btn_startsecond);
        btn_startSecond.setOnClickListener(btn_startSecListener);

        Button btn_BMI = (Button)findViewById(R.id.btn_BMI);
        btn_BMI.setOnClickListener(btn_BMIListener);
    }

    //------------------------------------------------start  second activity  ---------------------------------------------------------
    View.OnClickListener btn_startSecListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
    };


    //------------------------------------------------start  BMI  activity  -------------------------------------------------------------
    View.OnClickListener btn_BMIListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            EditText edt_height = (EditText)findViewById(R.id.edt_height);
            EditText edt_weight = (EditText)findViewById(R.id.edt_weight);

            Intent BMIintent = new Intent();
            BMIintent.setClass(MainActivity.this, BMIActivity.class);

            Bundle bundle = new Bundle();
            bundle.putString("HEIGHT", edt_height.getText().toString());
            bundle.putString("WEIGHT", edt_weight.getText().toString());

            BMIintent.putExtras(bundle);
            startActivity(BMIintent);
        }
    };

}
