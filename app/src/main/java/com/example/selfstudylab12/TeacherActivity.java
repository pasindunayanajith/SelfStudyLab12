package com.example.selfstudylab12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.selfstudylab12.LoginActivity.STNAME;

public class TeacherActivity extends AppCompatActivity {

    TextView name;

    EditText subject,m;

    Button send;

    DatabaseHelper DB;

    String subjects,messages,n;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        DB = new DatabaseHelper(this);

        name = (TextView)findViewById(R.id.name);

        subject = (EditText) findViewById(R.id.subject);
        m = (EditText) findViewById(R.id.mes);

        send = (Button) findViewById(R.id.send);

        Intent intent = getIntent();

        n = intent.getStringExtra(STNAME);

        name.setText("Welcome "+n);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveMes();

            }
        });




    }

    private void saveMes() {

        subjects = subject.getText().toString();
        messages = m.getText().toString();

       /* Intent i = getIntent();

        String nameUser = i.getStringExtra(STNAME);*/

        boolean isSaved = DB.saveMessages(n,subjects,messages);

        if(isSaved == true)
        {
            Toast.makeText(this, "Message Saved Successfully", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Error Saving Message", Toast.LENGTH_SHORT).show();
        }






    }
}
