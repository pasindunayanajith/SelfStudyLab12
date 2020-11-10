package com.example.selfstudylab12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

;

public class MessageActivity extends AppCompatActivity {

    TextView sub,mes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        sub = (TextView)findViewById(R.id.sub);
        mes = (TextView)findViewById(R.id.mes);

        Intent intent = getIntent() ;








    }
}
