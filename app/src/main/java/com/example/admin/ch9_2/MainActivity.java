package com.example.admin.ch9_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_startSecond = (Button)findViewById(R.id.btn_startsecond);
        btn_startSecond.setOnClickListener(btn_startSecListener);

        Button btn_BMI = (Button)findViewById(R.id.btn_BMI);
        btn_BMI.setOnClickListener(btn_BMIListener);

        Button btn_Horoscope = (Button)findViewById(R.id.btn_horoscope);
        btn_Horoscope.setOnClickListener(btn_horoscopeListener);
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

    //-----------------------------------------start Horoscope activity -------------------------------------------------------------------
    private static final int SET_HOROSCOPE = 1;
    private EditText edt_month;
    private EditText edt_day;

    View.OnClickListener btn_horoscopeListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            int month, day;
            month = Integer.parseInt(edt_month.getText().toString());
            day = Integer.parseInt(edt_day.getText().toString());
            if (month <1 || month >12 || day <1 || day>31){
                Toast.makeText(MainActivity.this, "資料範圍有誤" , Toast.LENGTH_SHORT).show();
                return;
            }
            Intent HoroscopeIntent = new Intent(MainActivity.this, HoroscopeActivity.class);
            HoroscopeIntent.putExtra("MONTH", month);
            HoroscopeIntent.putExtra("DAY", day);
            startActivityForResult(HoroscopeIntent, SET_HOROSCOPE);

        }
    };

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case SET_HOROSCOPE:
                if (requestCode == RESULT_OK){
                    Bundle bundle = data.getExtras();
                    TextView txv_horoscopeResult = (TextView)findViewById(R.id.txv_horoscope);
                    txv_horoscopeResult.setText("星座："+bundle.getString("HOROSCOPE"));
                }
                break;
        }
    }

}
