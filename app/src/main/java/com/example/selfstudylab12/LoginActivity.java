package com.example.selfstudylab12;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText name,password;

    Button login;

    DatabaseHelper db;

    final static String STNAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);

        name = (EditText)findViewById(R.id.US);
        password = (EditText)findViewById(R.id.PW);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name = name.getText().toString();
                String Password = password.getText().toString();
                String type = null;
                String name = null;

                Cursor res =  db.login(Name,Password);

                while (res.moveToNext()){

                    name = res.getString(1);
                    type  = res.getString(3);

                }

                if(type.equals("student"))
                {

                    Intent intent = new Intent(LoginActivity.this,StudentActivity.class);

                    intent.putExtra(STNAME,name);

                    startActivity(intent);

                    //redirects to student activity and send his/her name to that activity using intent

                }
                else
                {

                    Intent intent = new Intent(LoginActivity.this,TeacherActivity.class);

                    intent.putExtra(STNAME,name);

                    startActivity(intent);

                    //redirects to student activity and send his/her name to that activity using intent


                }



                //  Toast.makeText(LoginActivity.this, ""+type, Toast.LENGTH_SHORT).show();



            }
        });
    }
}
