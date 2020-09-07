package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Data extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        tv=findViewById(R.id.tv);
        try {
            contactsDB db =new contactsDB(this);
            db.open();
            tv.setText(db.getData());
            db.close();
            Toast.makeText(Data.this,"Data shown!!",Toast.LENGTH_SHORT).show();

        }
        catch (Exception e){
            Toast.makeText(Data.this,"Exception Occured",Toast.LENGTH_SHORT).show();}
    }

    }

