package com.example.admin.ch9_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HoroscopeActivity extends AppCompatActivity {

    final int[] bound = {20, 19, 21, 20, 21, 21, 23, 23, 23, 23, 22, 22};
    final String[] name = {"摩羯座", "水瓶座", "雙魚座", "白羊座", "金牛座", "雙子座", "巨蟹座", "獅子座", "處女座", "天秤座", "天蠍座", "射手座"};
    private String horoscope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscope);

        displayHoroscope();
        Button btn_back = (Button)findViewById(R.id.btn_horoscopeBack);
        btn_back.setOnClickListener(btn_backListener);
    }

    private void displayHoroscope(){
        int month, day;

        Intent myIntent = this.getIntent();
        month = myIntent.getIntExtra("MONTH", 1);
        day = myIntent.getIntExtra("DAY", 1);

        TextView txv_output = (TextView)findViewById(R.id.txv_horoscope);
        if (day < bound[month-1]){
            txv_output.setText(name[month-1]);
        }else if(month == 12) {
            txv_output.setText(name[0]);
        }else{
            txv_output.setText(name[month]);
        }
        horoscope = txv_output.getText().toString();
    }

    View.OnClickListener btn_backListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent replyIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("HOROSCOPE", horoscope);
            replyIntent.putExtras(bundle);
            setResult(RESULT_OK, replyIntent);
            finish();
        }
    };

}
