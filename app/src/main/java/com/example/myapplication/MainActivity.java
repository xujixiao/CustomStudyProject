package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"xujixao",Toast.LENGTH_LONG).show();
        show();
    }
    public  void show(){
        Toast.makeText(this,"gulina",Toast.LENGTH_LONG).show();
    }
}
