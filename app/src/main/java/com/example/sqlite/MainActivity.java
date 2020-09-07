package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {
EditText edtName,edtTel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName=findViewById(R.id.edName);
        edtTel=findViewById(R.id.edTel);
    }
    public  void  btnSaveData(View v) {
        String etName = edtName.getText().toString().trim();
        String etCell = edtTel.getText().toString().trim();
        try{
            contactsDB db=new contactsDB(this);
            db.open();
            db.createEntry(etName,etCell);
            db.close();
            Toast.makeText(MainActivity.this,"Data saved!!",Toast.LENGTH_SHORT).show();
            edtName.setText("");
            edtTel.setText("");
        }
        catch (Exception e){

                Toast.makeText(MainActivity.this,"Exception Occured",Toast.LENGTH_SHORT).show();

        }
    }
    public  void  btnShowData(View v){
        startActivity(new Intent(this,Data.class));
    }
    public  void  btnEditData(View v){
try {
    contactsDB db =new contactsDB(this);
    db.open();
    db.updateEntry("1","John","56423390");
    db.close();
    Toast.makeText(MainActivity.this,"Data edited!!",Toast.LENGTH_SHORT).show();

}
catch (Exception e){
        Toast.makeText(MainActivity.this,"Exception Occured",Toast.LENGTH_SHORT).show();}
    }
    public  void  btnDeleteData(View v){
        try {
            contactsDB db =new contactsDB(this);
            db.open();
            db.deleteEntry("1");
            db.close();
            Toast.makeText(MainActivity.this,"Data deleted!!",Toast.LENGTH_SHORT).show();

        }
        catch (Exception e){
            Toast.makeText(MainActivity.this,"Exception Occured",Toast.LENGTH_SHORT).show();}
    }
    }

