package com.example.selfstudylab12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.selfstudylab12.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper db;

    EditText Name , Password ;

    String name , password , type ;

    Button register,loginR;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);


        Name = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        register = (Button) findViewById(R.id.register);
        loginR = (Button) findViewById(R.id.loginR);



        RadioGroup rg = (RadioGroup) findViewById(R.id.group);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch(i){
                    case R.id.teacher:
                        type = "teacher";



                        Toast.makeText(RegisterActivity.this, "teacher", Toast.LENGTH_SHORT).show();
                        // do operations specific to this selection
                        break;
                    case R.id.student:

                        type = "student";
                        // do operations specific to this selection
                        Toast.makeText(RegisterActivity.this, "student", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();

            }
        });


        loginR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);

                startActivity(intent);
            }
        });


    }

    private void Register() {

        name = Name.getText().toString();
        password = Password.getText().toString();


        boolean isInserted = db.insertData(name,password,type);

        if(isInserted == true)
            Toast.makeText(RegisterActivity.this,"Registered Successfully",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(RegisterActivity.this,"Error",Toast.LENGTH_LONG).show();



    }
}
