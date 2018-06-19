package com.example.admin.ch9_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btn_closeSecond = (Button)findViewById(R.id.btn_closeSecond);
        btn_closeSecond.setOnClickListener(btn_closeSecListener);
    }

    View.OnClickListener btn_closeSecListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}
